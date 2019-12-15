import java.util.*;

public class HugeNumber2 {

	private class Node {
		private int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	Node head = null;

	HugeNumber2(String n) {
		for (int i = 0; i < n.length(); i++) {

			Node new_node = new Node(Character.getNumericValue(n.charAt(i)));
			new_node.next = null;

			if (head == null) {
				new_node.prev = null;
				head = new_node;

			}

			else {
				Node last = head;
				while (last.next != null) {
					last = last.next;
				}

				last.next = new_node;
				new_node.prev = last;

			}
		}

	}

	HugeNumber2(HugeNumber2 h) {
		this.head = h.head;

	}

	String getNumber() {

		if (this.head == null)
			return "no number is present";
		else {
			Node ref = this.head;
			String num = "";
			while (ref != null) {
				num += String.valueOf(ref.data);
				ref = ref.next;
			}

			return num;

		}

	}

	Node addMostSigDigit(int d) {
		Node new_node = new Node(d);
		new_node.prev = null;
		if (this.head == null) {
			new_node.next = null;
			head = new_node;

		} else {
			new_node.next = head;
			head = new_node;

		}
		return head;

	}

	void reset() {
		this.head = null;
		System.out.println("Number resetted");

	}

	public HugeNumber2 add(HugeNumber2 otherNumber) {
		String ans = "";
		int carry = 0;
		Node tail1 = this.head;
		Node tail2 = otherNumber.head;
		while (tail1.next != null)
			tail1 = tail1.next;
		while (tail2.next != null)
			tail2 = tail2.next;
		int tem = 0;
		while (tail1 != null && tail2 != null) {
			tem = tail1.data + tail2.data + carry;
			if (tem < 10) {
				ans = String.valueOf(tem) + ans;

			} else {
				ans = String.valueOf(tem % 10) + ans;
				tem /= 10;
				carry = tem;
			}
			tail1 = tail1.prev;
			tail2 = tail2.prev;

		}
		if (tem < 10) {
			ans = String.valueOf(tem) + ans;
		} else {
			ans = String.valueOf(tem % 10) + ans;
			tem /= 10;
			carry = tem;
		}

		return new HugeNumber2(ans);

	}

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number");
		String n = s.next();

		HugeNumber2 h1 = new HugeNumber2(n);

		System.out.println(h1.getNumber());

		HugeNumber2 h2 = new HugeNumber2(h1);
		System.out.println(h2.getNumber());

		HugeNumber2 sum = h1.add(h2);
		System.out.println("Sum of the numbers is :" + sum.getNumber());

	}

}
