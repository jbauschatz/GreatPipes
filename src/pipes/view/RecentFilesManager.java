package pipes.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

/**
 * This class tracks files that the user opens and saves them for later access via File -> Open Recent
 */
public class RecentFilesManager {

    private final String PREF_OPEN_RECENT_PATHS = "gp_open_recent_paths";

    public File[] getRecentFiles() {
        return recentFiles.toArray(new File[recentFiles.size()]);
    }

    public void addRecentFile(File newFile) {
        for (File existingFile : recentFiles) {
            if (existingFile.getAbsolutePath().equals(newFile.getAbsolutePath()))
                return;
        }
        recentFiles.add(0, newFile);
        save();
    }

    private void save() {
        StringBuilder paths = new StringBuilder();
        for (File file : recentFiles) {
            if (paths.length() > 0)
                paths.append(",");
            paths.append(file.getAbsolutePath());
        }
        preferences.put(PREF_OPEN_RECENT_PATHS, paths.toString());
    }

    private void load() {
        recentFiles.clear();
        String[] recentPaths = preferences.get(PREF_OPEN_RECENT_PATHS, "").split(",");
        if (recentPaths != null) {
            for (final String path : recentPaths) {
                File f = new File(path);
                if (f.exists()) {
                    recentFiles.add(f);
                }
            }
        }
    }

    public RecentFilesManager() {
        recentFiles = new ArrayList<>();
        preferences = Preferences.userNodeForPackage(RecentFilesManager.class);
        load();
    }

    private final List<File> recentFiles;
    private final Preferences preferences;
}
