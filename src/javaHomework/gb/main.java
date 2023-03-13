package javaHomework.gb;

import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    void insert(String data, int pos) {
        Node new_node = new Node(data);
        if (pos == 1) {
            new_node.next = this.head;
            this.head = new_node;
        } else {
            Node prev_node = this.get_node(pos - 1);
            new_node.next = prev_node.next;
            prev_node.next = new_node;
        }
    }

    Node get_node(int pos) {
        Node curr_node = this.head;
        for (int i = 1; i < pos; i++) {
            if (curr_node == null) {
                throw new IndexOutOfBoundsException("Position out of range");
            }
            curr_node = curr_node.next;
        }
        return curr_node;
    }

    void delete(int pos) {
        if (pos == 1) {
            this.head = this.head.next;
        } else {
            Node prev_node = this.get_node(pos - 1);
            prev_node.next = prev_node.next.next;
        }
    }

    void print_node(int pos) {
        Node node = this.get_node(pos);
        System.out.println(node.data);
        this.delete(pos);
    }
}

public class main {
    public static void main(String[] args) {
        LinkedList linked_list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду: ");
            String user_input = scanner.nextLine();
            if (user_input.equals("exit")) {
                break;
            } else {
                String[] input_parts = user_input.split("~");
                String command = input_parts[0];
                int pos = Integer.parseInt(input_parts[1]);
                if (command.equals("print")) {
                    linked_list.print_node(pos);
                } else {
                    String text = command;
                    linked_list.insert(text, pos);
                }
            }
        }
        scanner.close();
    }
}

