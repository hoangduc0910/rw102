import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Group group1 = new Group();
        group1.id = 1;
        group1.groupName = "group1";
        group1.createDate = LocalDate.now();

        Group group2 = new Group();
        group2.id = 2;
        group2.groupName = "group2";
        group2.createDate = LocalDate.now();

        Group group3 = new Group();
        group3.id = 3;
        group3.groupName = "group3";
        group3.createDate = LocalDate.now();
        Group[] groups = new Group[] {group1, group2, group3};


        String[] names = new String[] {"Accounting", "Boss of director", "Marketing", "Sale", "Waiting room"};
        Exercise5.question6(names);
    }
}