package Process;

import Network.Packet;
import Network.PacketContainer;
import lombok.extern.log4j.Log4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by son on 2018-10-28.
 */
@Log4j
public class NetworkObserver {
    private PacketContainer packetContainer;

    public NetworkObserver(final PacketContainer packetContainer) {
        this.packetContainer = packetContainer;
    }

    public void detect() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "netstat -no");
        Process process = processBuilder.start();
        System.out.println("네트워크 체크 중...");
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    packetContainer.parse(line);
                    line = bufferedReader.readLine();
                }
                process.waitFor();
            } catch (InterruptedException e) {
                log.warn(e.getMessage(), e);
            }
        process.destroy();
    }

    public void availabilityProcess() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();

        for (Packet packet : packetContainer.getPackets()) {
            if (packet.getPid().equals(String.valueOf(0))) {
                continue;
            }
            processBuilder.command("cmd.exe", "/c", "tasklist | findstr /c:\"" + packet.getPid() + "\"");
            Process process = processBuilder.start();

            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    packet.setProcessName(line.split(" ")[0]);
                    line = bufferedReader.readLine();
                }
                process.waitFor();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            process.destroy();
        }
    }
}
