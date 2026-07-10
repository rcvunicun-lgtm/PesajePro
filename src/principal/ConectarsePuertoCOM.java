package principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import purejavacomm.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;

public class ConectarsePuertoCOM {

	private static JList<String> portList;
	private boolean running = true;

	private SerialPort port;
	private Integer baudRate;
	private Integer dataBits;
	private Integer stopBits;
	private Integer parity;
	private Integer waitingTime;
	private String flowControl;  // Variable para almacenar la configuración del flujo



	public ConectarsePuertoCOM(String port, String baudRate, String dataBits, String stopBits, String parity, String flowControl, String waitingTime) {
	    // Validación de la entrada para el puerto
	    this.port = SerialPort.getCommPort(port);

	    // Conversión de la velocidad de baudios
	    try {
	        this.baudRate = Integer.parseInt(baudRate);
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Velocidad de baudios no válida: " + baudRate);
	    }

	    // Comprobación para dataBits
	    switch (dataBits) {
	        case "5":
	            this.dataBits = 5;
	            break;
	        case "6":
	            this.dataBits = 6;
	            break;
	        case "7":
	            this.dataBits = 7;
	            break;
	        case "8":
	            this.dataBits = 8;
	            break;
	        default:
	            throw new IllegalArgumentException("Número de Data Bits no válido: " + dataBits);
	    }

	    // Comprobación de los bits de parada
	    switch (stopBits) {
	        case "1.0":
	            this.stopBits = SerialPort.ONE_STOP_BIT;
	            break;
	        case "1.5":
	            this.stopBits = SerialPort.ONE_POINT_FIVE_STOP_BITS; // Verifica si tu biblioteca soporta este valor
	            break;
	        case "2.0":
	            this.stopBits = SerialPort.TWO_STOP_BITS;
	            break;
	        default:
	            throw new IllegalArgumentException("Valor de Stop Bits no válido: " + stopBits);
	    }

	    // Comprobación de la paridad
	    switch (parity) {
	        case "NO_PARITY":
	            this.parity = SerialPort.NO_PARITY;
	            break;
	        case "EVEN_PARITY":
	            this.parity = SerialPort.EVEN_PARITY;
	            break;
	        case "ODD_PARITY":
	            this.parity = SerialPort.ODD_PARITY;
	            break;
	        case "MARK_PARITY":
	            this.parity = SerialPort.MARK_PARITY;
	            break;
	        case "SPACE_PARITY":
	            this.parity = SerialPort.SPACE_PARITY;
	            break;
	        default:
	            throw new IllegalArgumentException("Paridad no válida: " + parity);
	    }

	    // Asignación de la velocidad de lectura
	    try {
	        this.waitingTime = Integer.parseInt(waitingTime);
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Velocidad de espera no válida: " + waitingTime);
	    }

	    // Asignación del control de flujo
	    this.flowControl = flowControl;
	  	    
	}

	private void setFlowControlForPort() {
	    if (flowControl != null) {
	        switch (flowControl) {
	            case "Hardware (RTS/CTS)":
	                this.port.setFlowControl(SerialPort.FLOW_CONTROL_RTS_ENABLED | 
	                                        SerialPort.FLOW_CONTROL_CTS_ENABLED);
	                break;
	            case "Hardware (CTS only)":
	                this.port.setFlowControl(SerialPort.FLOW_CONTROL_CTS_ENABLED);
	                break;
	            case "Hardware (DSR/DTR)":
	                this.port.setFlowControl(SerialPort.FLOW_CONTROL_DSR_ENABLED | 
	                                        SerialPort.FLOW_CONTROL_DTR_ENABLED);
	                break;
	            case "Hardware (DTR only)":
	                this.port.setFlowControl(SerialPort.FLOW_CONTROL_DTR_ENABLED);
	                break;
	            case "Soft (XON/XOFF entrada)":
	                this.port.setFlowControl(SerialPort.FLOW_CONTROL_XONXOFF_IN_ENABLED);
	                break;
	            case "Soft (XON/XOFF salida)":
	                this.port.setFlowControl(SerialPort.FLOW_CONTROL_XONXOFF_OUT_ENABLED);
	                break;
	            case "Combinación RTS + CTS":
	                this.port.setFlowControl(SerialPort.FLOW_CONTROL_RTS_ENABLED | 
	                                        SerialPort.FLOW_CONTROL_CTS_ENABLED);
	                break;
	            case "NONE":
	                this.port.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED);
	                break;
	            default:
	                throw new IllegalArgumentException("Control de flujo no válido: " + flowControl);
	        }
	    } else {
	        this.port.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED);
	    }
	}




	// Cargar puertos disponibles en la JList
	public static void cargarPuertosDisponibles() {
		portList = new JList<>();
		SerialPort[] availablePorts = SerialPort.getCommPorts();
		DefaultListModel<String> portModel = new DefaultListModel<>();

		if (availablePorts.length == 0) {
			// Si no hay puertos, añade un mensaje predeterminado
			portModel.addElement("No hay puertos disponibles");
		} else {
			for (SerialPort port : availablePorts) {
				portModel.addElement(port.getSystemPortName());
			}
		}
		portList.setModel(portModel);
	}

	public static ArrayList<String> obtenerPuertos() {
		DefaultListModel<String> model = (DefaultListModel<String>) portList.getModel();
		ArrayList<String> listaPuertos = new ArrayList<>();
		for (int i = 0; i < model.size(); i++) {
			listaPuertos.add(model.get(i));
		}
		return listaPuertos;
	}

	
	public void establecerConexionPuerto() {
	    // 1. Configurar parámetros SIEMPRE (sin depender de 'running')
	    port.setComPortParameters(
	        this.baudRate,
	        this.dataBits,
	        this.stopBits,
	        this.parity
	    );
	    
	    setFlowControlForPort();
	    
	    // 2. Abrir solo si no está abierto Y running lo permite
	    if (!running) {
	        running = true;
	        if (!port.isOpen()) {
	            port.openPort();
	        }
	        
	        // 3. Configuración de timeouts (solo al activar)
	        // Para aplicaciones en tiempo real (máxima responsividad)
	        /*
	        port.setComPortTimeouts(
	            SerialPort.TIMEOUT_NONBLOCKING,
	            0,
	            0
	        );
			*/
	        // Para operaciones con timeout preciso (tu caso)
	        
	        port.setComPortTimeouts(
	            SerialPort.TIMEOUT_READ_SEMI_BLOCKING,
	            100, // 100ms de espera
	            0
	        );

	        // Para transferencias críticas (sin timeout)
	        /*
	        port.setComPortTimeouts(
	            SerialPort.TIMEOUT_READ_BLOCKING,
	            0,
	            0
	        );
	        */
	    }
	    
	}


	public void cerrarConexion() {
	    running = false;
	    if (port != null && port.isOpen()) {
	        port.closePort();
	    }
	}


	// Variable de instancia para acumular datos entre llamadas
	private StringBuilder rawDataBuffer = new StringBuilder();
	private StringBuilder binaryBuffer = new StringBuilder();

	public void startReadingData(SerialPort selectedPort, Consumer<String> dataHandler) {
	    new Thread(() -> {
	        byte[] buffer = new byte[32];

	        // Listener para errores de paridad
	        selectedPort.addDataListener(new SerialPortDataListener() {
	            @Override
	            public int getListeningEvents() {
	                return SerialPort.LISTENING_EVENT_PARITY_ERROR;
	            }

	            public void serialEvent(SerialPortEvent event) {
	                if (event.getEventType() == SerialPort.LISTENING_EVENT_PARITY_ERROR) {
	                    SwingUtilities.invokeLater(() -> {
	                        JOptionPane.showMessageDialog(
	                            null,
	                            "Se detectó un error de paridad en la comunicación serial",
	                            "Error de Paridad",
	                            JOptionPane.ERROR_MESSAGE
	                        );
	                    });

	                    System.err.println("[ERROR] Byte con paridad incorrecta");
	                    dataHandler.accept("\n[ERROR] Byte con paridad incorrecta\n");
	                }
	            }

	            @Override
	            public void serialEvent(com.fazecast.jSerialComm.SerialPortEvent arg0) {
	                // Método requerido
	            }
	        });

	        while (running) {
	            try {
	                if (!selectedPort.isOpen()) {
	                    running = false;
	                    dataHandler.accept("El puerto se ha desconectado.");
	                    break;
	                }

	                int availableBytes = selectedPort.bytesAvailable();
	                if (availableBytes > 0) {
	                    Arrays.fill(buffer, (byte) 0);
	                    int bytesRead = selectedPort.readBytes(buffer, Math.min(buffer.length, availableBytes));

	                    // =============== LÓGICA PRINCIPAL MODIFICADA ===============
	                    for (int i = 0; i < bytesRead; i++) {
	                        int byteValue = buffer[i] & 0xFF;

	                        binaryBuffer.append(String.format("%8s", Integer.toBinaryString(byteValue)).replace(' ', '0'))
	                                    .append(" ");

	                        rawDataBuffer.append((char) byteValue);
	                    }

	                    // Enviar los datos binarios inmediatamente
	                    if (binaryBuffer.length() > 0) {
	                        dataHandler.accept(binaryBuffer.toString().trim());
	                        binaryBuffer.setLength(0);
	                        rawDataBuffer.setLength(0);
	                    }
	                }

	                Thread.sleep(waitingTime);
	            } catch (Exception e) {
	                SwingUtilities.invokeLater(() -> {
	                    JOptionPane.showMessageDialog(
	                        null,
	                        "[ERROR] " + e.getMessage(),
	                        "Error",
	                        JOptionPane.ERROR_MESSAGE
	                    );
	                });

	                dataHandler.accept("\n[ERROR] " + e.getMessage() + "\n");
	                running = false;
	            }
	        }

	        if (selectedPort.isOpen()) {
	            selectedPort.removeDataListener();
	            selectedPort.closePort();
	        }
	    }).start();
	}

		
	public boolean isPortAvailable() {
	    // Verificar si el puerto está presente en los puertos disponibles del sistema
	    SerialPort[] availablePorts = SerialPort.getCommPorts();
	    for (SerialPort sp : availablePorts) {
	        if (sp.getSystemPortName().equals(port.getSystemPortName())) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean isPortOpen() {
	    return port != null && port.isOpen();
	}


	public SerialPort getPort() {
		return port;
	}

	public Integer getBaudRate() {
		return baudRate;
	}

	public Integer getDataBits() {
		return dataBits;
	}

	public Integer getStopBits() {
		return stopBits;
	}

	public Integer getParity() {
		return parity;
	}

	public Integer getWaitingTime() {
		return waitingTime;
	}
}
