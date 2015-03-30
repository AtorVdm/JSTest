package classes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AutoUpdate {
    private final String LIBRARIES_PATH = "src" + File.separator + "libs" + File.separator;

    public static void main(String[] args) {
        AutoUpdate updater = new AutoUpdate();
        updater.importLib("jquery.js", "http://code.jquery.com/jquery-2.1.3.min.js", true);
        updater.importLib("angular.js", "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js", true);
        updater.importLib("react.js", "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-xaf1/t39.3284-6/11057099_786641398071747_1238751788_n.js", true);
        updater.importLib("backbone.js", "http://backbonejs.org/backbone-min.js", true);
        updater.importLib("ember.js", "http://builds.emberjs.com/release/ember.min.js", true);
        System.out.println("Done!");
    }

    public void importLib(String libName, String libPath, boolean primary) {
        try {
            URL website = new URL(libPath);
            String outputPath = LIBRARIES_PATH + (primary? "core": "other") + File.separator + libName;
            Files.copy(website.openStream(), Paths.get(outputPath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(libName + " loaded successfully!");
        } catch (IOException ex) {
            System.out.println("Library import failed: " + ex.getMessage());
        }
    }
}
