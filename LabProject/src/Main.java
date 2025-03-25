import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        System.out.println("Welcome to Library Management System");
        System.out.println("1:Monitor the database" +
                "\n2:Insert book to the database" +
                "\n3:Delete book from the database" +
                "\n4:Update book to the database" +
                "\nQuit:For quit the program");
        String action = GetInput.getInput("Please enter the action you want to perform:");

        while (!action.equalsIgnoreCase("Quit")) {

            if (action.equals("1")) {
                System.out.println("Database is loading...");
                Thread.sleep(Long.parseLong("1000"));
                DbOps.showData();
            } else if (action.equals("2")) {
                String book_name = GetInput.getInput("Please enter the book name:");
                String book_author = GetInput.getInput("Please enter the book author:");
                DbOps.insertData(book_name, book_author);

            } else if (action.equals("3")) {
                String book_id = GetInput.getInput("Please enter the book id that you want to delete:");
                int book_id_int = Integer.parseInt(book_id);
                DbOps.deleteData(book_id_int);

            } else if (action.equals("4")) {
                String book_id = GetInput.getInput("Please enter the book id that you want to update:");
                String thingsToUpdate = GetInput.getInput("Please enter the title that you want to update:");
                String newStatement = GetInput.getInput("Please enter the updated contents:");
                int book_id_int = Integer.parseInt(book_id);
                DbOps.updateData(thingsToUpdate, newStatement, book_id_int);
            } else {
                System.out.println("Invalid option. Please try again.");

            }
            action = GetInput.getInput("Please enter the action you want to perform: ");
        }
        System.out.println("Goodbye!");
    }
}
