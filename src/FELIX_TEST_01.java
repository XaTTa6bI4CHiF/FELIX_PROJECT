public class FELIX_TEST_01 //DatabaseBackup
{
    public static void performBackup()
    {
        // Delete old files.
        if (Config.BACKUP_DAYS > 0)
        {
            final long cut = LocalDateTime.now().minusDays(Config.BACKUP_DAYS).toEpochSecond(ZoneOffset.UTC);
            final Path path = Paths.get(Config.BACKUP_PATH);
            try
            {
                Files.list(path).filter(n ->
                {
                    try
                    {
                        return Files.getLastModifiedTime(n).to(TimeUnit.SECONDS) < cut;
                    }
                    catch (Exception ex)
                    {
                        return false;
                    }
                }).forEach(n ->
                {
                    try
                    {
                        Files.delete(n);
                    }
                    catch (Exception ex)
                    {
                        // Ignore.
                    }
                });
            }
            catch (Exception e)
            {
                // Ignore.
            }
        }

        // Dump to file.
        final String mysqldumpPath = System.getProperty("os.name").toLowerCase().contains("win") ? Config.MYSQL_BIN_PATH : "";
        try
        {
            final Process process = Runtime.getRuntime().exec(mysqldumpPath + "mysqldump -u " + Config.DATABASE_LOGIN + (Config.DATABASE_PASSWORD.trim().isEmpty() ? "" : " -p" + Config.DATABASE_PASSWORD) + " " + Config.DATABASE_URL.replace("jdbc:mariadb://", "").replaceAll(".*\\/|\\?.*", "") + " -r " + Config.BACKUP_PATH + (Config.SERVER_MODE == ServerMode.GAME ? "game" : "login") + new SimpleDateFormat("_yyyy_MM_dd_HH_mm'.sql'").format(new Date()));
            process.waitFor();
        }
        catch (Exception e)
        {
            // Ignore.
        }
    }
}
