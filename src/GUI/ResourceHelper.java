package GUI;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;

public class ResourceHelper {

    public static ImageIcon getImageIcon(String fileName) {
        File file = findFile(fileName);
        if (file != null) {
            return new ImageIcon(file.getAbsolutePath());
        }
        return new ImageIcon();
    }

    public static File findFile(String fileName) {
        Path start = Paths.get(System.getProperty("user.dir")).toAbsolutePath().normalize();
        for (Path dir = start; dir != null; dir = dir.getParent()) {
            Path direct = dir.resolve(fileName);
            if (Files.exists(direct) && Files.isRegularFile(direct)) {
                return direct.toFile();
            }
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path entry : stream) {
                    if (Files.isRegularFile(entry)
                            && entry.getFileName().toString().equalsIgnoreCase(fileName)) {
                        return entry.toFile();
                    }
                }
            } catch (IOException ex) {
                // Ignore and continue searching.
            }
        }
        return null;
    }
}
