import java.util.*;

class Client {
    String nameClient;
    int ageClient;

    Client(String name, int age) {
        nameClient = name;
        ageClient = age;
    }
}

class Account {
    int idAccount;

    Account(int account) {
        idAccount = account;
    }
}

class SearchClientList {
    static void searchClient(int cl, HashMap<Client, HashSet<Account>> acList) {
        for (Map.Entry<Client, HashSet<Account>> entry : acList.entrySet()) {
            Iterator<Account> i = entry.getValue().iterator();
            while (i.hasNext())
                if (i.next().idAccount == cl) {
                    System.out.println("Владельцем счета " + cl + " является " + entry.getKey().nameClient);
                }
        }
    }

    static void searchAccount(Client cl, HashMap<Client, HashSet<Account>> acList) {
        for (Map.Entry<Client, HashSet<Account>> entry : acList.entrySet()) {
            if (entry.getKey() == cl) {
                System.out.println("Счета клиента '" + entry.getKey().nameClient + "':");
                Iterator<Account> i = entry.getValue().iterator();
                while (i.hasNext())
                    System.out.println(i.next().idAccount);
            }
        }
    }
}

public class ClientList {

    public static void main(String[] args) {
        Client client1 = new Client("Tom", 27);
        Client client2 = new Client("Viktor", 32);

        Account account1 = new Account(1000);
        Account account2 = new Account(2000);
        Account account3 = new Account(3000);
        Account account4 = new Account(4000);
        Account account5 = new Account(5000);

        HashSet<Account> accountList1 = new HashSet();
        accountList1.add(account1);
        accountList1.add(account2);
        accountList1.add(account3);

        HashSet<Account> accountList2 = new HashSet();
        accountList2.add(account4);
        accountList2.add(account5);

        HashMap<Client, HashSet<Account>> clientList = new HashMap();
        clientList.put(client1, accountList1);
        clientList.put(client2, accountList2);

        // Поиск счетов по клиенту
        SearchClientList.searchAccount(client1, clientList);
        SearchClientList.searchAccount(client2, clientList);
        // Поиск клиента по счету
        SearchClientList.searchClient(1000, clientList);
        SearchClientList.searchClient(5000, clientList);
    }

}