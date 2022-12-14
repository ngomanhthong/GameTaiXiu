import java.util.Random;
import java.util.Scanner;

public class MaiApp {
	public static void main(String[] args) {
		double taiKhoanNguoiChoi = 5000;
		Scanner sc = new Scanner(System.in);
		int luaChon = 1;
		do {
			System.out.println("**************nhấn 1 để chơi tiếp nhấn phím khác để thoát***************");
			luaChon = sc.nextInt();

			if (luaChon == 1) {
				System.out.println("***Bắt đầu chơi***");
				// đặt cược
				System.out.println("*****bạn đang có" + taiKhoanNguoiChoi + " xin mời đặt cược*****");
				double datCuoc;
				do {
					System.out.println("*****đặt cược số tiền > 0 && < " + taiKhoanNguoiChoi + "*****");
					datCuoc = sc.nextDouble();
				} while (datCuoc <= 0 || datCuoc > taiKhoanNguoiChoi);
				// chọn tài xỉu
				int luaChonTaiXiu;
				do {
					System.out.println("*** nhấn 1 để chọn tài && nhấn 2 để chọn xỉu***");
					luaChonTaiXiu = sc.nextInt();
				} while (luaChonTaiXiu != 1 && luaChonTaiXiu != 2);
				// Tung xúc xắc
				Random xucXac1 = new Random();
				Random xucXac2 = new Random();
				Random xucXac3 = new Random();
				int giaTri1 = xucXac1.nextInt(1, 7);
				int giaTri2 = xucXac2.nextInt(1, 7);
				int giaTri3 = xucXac3.nextInt(1, 7);
				System.out.print("kết quả là [" + giaTri1 + "] ");
				System.out.print("[" + giaTri2 + "] ");
				System.out.println("[" + giaTri3 + "]");
				// tính tổng là chẳn hay lẻ
				// nếu tổng là 3 hoặc 18 => nhà cái ăn hết;
				// nếu tổng là (4->10) => xỉu
				// nếu tổng là (11->17) => tài
				int tong = giaTri1 + giaTri2 + giaTri3;
				if (tong == 3 || tong == 18) {
					System.out.println("*****tổng là " + tong + " nhà cái ăn hết*****");
					taiKhoanNguoiChoi -= datCuoc;
					System.out.println("bạn còn " + taiKhoanNguoiChoi);
				} else if (tong >= 4 && tong <= 10) {
					System.out.println("*****tổng là " + tong + " xỉu*****");
					if (luaChonTaiXiu == 2) {
						taiKhoanNguoiChoi += datCuoc;
						System.out.println("****bạn còn " + taiKhoanNguoiChoi + "*****");
					} else {
						taiKhoanNguoiChoi -= datCuoc;
						System.out.println("****bạn còn " + taiKhoanNguoiChoi + "****");
					}
				} else {
					System.out.println("*****tổng là " + tong + " tài******");
					if (luaChonTaiXiu == 2) {
						taiKhoanNguoiChoi -= datCuoc;
						System.out.println("****bạn còn " + taiKhoanNguoiChoi + "****");
					} else {
						taiKhoanNguoiChoi += datCuoc;
						System.out.println("****bạn còn " + taiKhoanNguoiChoi + "****");
					}

				}
			}
			if (taiKhoanNguoiChoi == 0) {
				System.out.println(
						"**************không đủ số tiền đặt cược mời nhấn phím bất kì để thoát !=1***************");
			}

		} while (luaChon == 1);
		System.out.println("************Bạn đã thoát khỏi trò chơi***********");
	}

}
