import java.util.*;

class Client {
    String nameClient;
    int ageClient;

    Client(String name, int age) {
        nameClient = name;
        ageClient = age;
    }

    Client() {
    }
}

class Account {
    int idAccount;

    Account(int account) {
        idAccount = account;
    }
}

class SearchClientList {
    static Client searchClient(Account ac, HashMap<Client, HashSet<Account>> acList) {
        Client cl = new Client();
        for (Map.Entry<Client, HashSet<Account>> entry : acList.entrySet()) {
            Iterator<Account> i = entry.getValue().iterator();
            while (i.hasNext()) {
                if (i.next() == ac) {
                    cl = entry.getKey();
                }
            }
        }
        return cl;
    }

    static void printSearchClient(Client cl, Account ac) {
        System.out.println("Владельцем счета " + ac.idAccount + " является " + cl.nameClient);
    }

    // Поиск счетов клиента
    static HashSet<Account> searchAccount(Client cl, HashMap<Client, HashSet<Account>> clList) {
        HashSet<Account> acList = clList.get(cl);
        return acList;
    }

    static void printListAccountClient(Client cl, HashSet<Account> acList) {
        System.out.println("Счета клиента '" + cl.nameClient + "':");
        Iterator<Account> i = acList.iterator();
        while (i.hasNext())
            System.out.println(i.next().idAccount);
    }
}

public class ClientList {

    public static void main(String[] args) {
        Client client1 = new Client("Tom", 27);
        Client client2 = new Client("Viktor", 32);
        Client client3 = new Client("Viktor", 32);

        Account account1 = new Account(1000);
        Account account2 = new Account(2000);
        Account account3 = new Account(3000);
        Account account4 = new Account(4000);
        Account account5 = new Account(5000);
        Account account6 = new Account(6000);

        HashSet<Account> accountList1 = new HashSet();
        accountList1.add(account1);
        accountList1.add(account2);
        accountList1.add(account3);

        HashSet<Account> accountList2 = new HashSet();
        accountList2.add(account4);
        accountList2.add(account5);

        HashSet<Account> accountList3 = new HashSet();
        accountList2.add(account6);

        HashMap<Client, HashSet<Account>> clientList = new HashMap();
        clientList.put(client1, accountList1);
        clientList.put(client2, accountList2);
        clientList.put(client3, accountList3);

        // Поиск счетов по клиенту
        HashSet<Account> accountListClient1 = SearchClientList.searchAccount(client1, clientList);
        SearchClientList.printListAccountClient(client1, accountListClient1);

        HashSet<Account> accountListClient2 = SearchClientList.searchAccount(client2, clientList);
        SearchClientList.printListAccountClient(client2, accountListClient2);

        HashSet<Account> accountListClient3 = SearchClientList.searchAccount(client3, clientList);
        SearchClientList.printListAccountClient(client3, accountListClient3);

        // Поиск клиента по счету
        Client searchClient1 = SearchClientList.searchClient(account1, clientList);
        SearchClientList.printSearchClient(searchClient1, account1);

        Client searchClient2 = SearchClientList.searchClient(account5, clientList);
        SearchClientList.printSearchClient(searchClient2, account5);
    }

}