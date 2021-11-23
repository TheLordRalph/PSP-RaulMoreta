import java.util.List;

public class ProcessLauncher {

    public Process launch(String path, String file) {

        ProcessBuilder processBuilder;

        try {
            processBuilder = new ProcessBuilder(path, file);
            return processBuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
