package karinzz.spring.core;

// KONSEP SINGLETON DI SPRING:
// Singleton adalah pola desain yang memastikan bahwa hanya ada satu instance dari kelas tertentu yang
// dibuat selama siklus hidup aplikasi. Walaupun di buat dengan variabel berbeda hasilnya akan tetap sama.
public class Database {
    private static Database database;

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }
    private Database() {

    }
}
