import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	Scanner scanner = new Scanner(System.in);
	ArrayList<String> arrayKode = new ArrayList<>();
	ArrayList<String> arrayNama = new ArrayList<>();
	ArrayList<String> arrayKelamin = new ArrayList<>();
	ArrayList<String> arrayJabatan = new ArrayList<>();
	ArrayList<Integer> arrayGaji = new ArrayList<>();
	ArrayList<String> arrayJabatanManager = new ArrayList<>();
	ArrayList<String> arrayJabatanSupervisor = new ArrayList<>();
	ArrayList<String> arrayJabatanAdmin = new ArrayList<>();
	
	int choose;
	String nama;
	String kelamin;
	String jabatan;
	String kode;
	int gaji;
	String ID;
	String tempNama;
	String tempKelamin;
	String tempJabatan;
	String tempKode;
	int tempGaji;
	int angkaUpdate;
	int angkaDelete;
	String bonus;
	
	public Main() {
		mainMenu();
	}
	
	public void mainMenu() {
		do {
			System.out.println("       Main Menu       ");
			System.out.println("=======================");
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.println("5. Exit");
			System.out.print("Choose : ");

			try {
				choose = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				choose = -1;
				scanner.nextLine();
			}
			System.out.println(" ");

		} while (choose < 1 || choose > 4 && choose != 5);
		
		switch (choose) {
		case 1:
			insertData();
			break;

		case 2:
			viewData();
			break;

		case 3:
			updateData();
			break;

		case 4:
			deleteData();
			break;

		case 5:
			System.exit(0);
			break;
		}
	}
	
	public void insertData() {
		do {
			System.out.print("Input Nama Karyawan [>= 3] : ");
			nama = scanner.nextLine();
		} while (nama.length() < 3);
		
		do {
			System.out.print("Input Jenis Kelamin [Laki-Laki | Perempuan] (Case Sensitive) : ");
			kelamin = scanner.nextLine();
		} while (!kelamin.equals("Laki-Laki") && !kelamin.equals("Perempuan"));
		
		do {
			System.out.print("Input Jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
			jabatan = scanner.nextLine();
		} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		
			if (jabatan.equals("Manager")) {
				gaji = 8000000;
				arrayJabatanManager.add(jabatan);
			}
		
			else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
				arrayJabatanSupervisor.add(jabatan);
			}
		
			else if (jabatan.equals("Admin")) {
				gaji = 4000000;
				arrayJabatanAdmin.add(jabatan);
			}
		
		Random random = new Random();
		ID = "" + (char) (random.nextInt(26) + 'A') + (char) (random.nextInt(26) + 'A') + "-" + (random.nextInt(10)) + (random.nextInt(10)) + (random.nextInt(10)) + (random.nextInt(10));
		System.out.println("Berhasil menambahkan karyawan dengan id " + ID);
		System.out.println(" ");
		
		arrayKode.add(ID);
		arrayNama.add(nama);
		arrayKelamin.add(kelamin);
		arrayJabatan.add(jabatan);
		arrayGaji.add(gaji);
		
		if (arrayJabatanManager.size() >= 3 || arrayJabatanManager.size() % 3 == 0 && jabatan.equals("Manager")) {
			bonus = "Bonus sebesar 10% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < arrayKode.size(); i++) {
				if (arrayJabatan.get(i).equals("Manager")) {
					bonus = bonus + arrayKode.get(i) + " ";
				}
			}
		System.out.println(bonus);
		}
		
		if (arrayJabatanSupervisor.size() >= 3 || arrayJabatanManager.size() % 3 == 0&& jabatan.equals("Supervisor")) {
			bonus = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < arrayKode.size(); i++) {
				if (arrayJabatan.get(i).equals("Supervisor")) {
					bonus = bonus + arrayKode.get(i) + " ";
				}
			}
		System.out.println(bonus);
		}
		
		if (arrayJabatanAdmin.size() >= 3 || arrayJabatanManager.size() % 3 == 0 && jabatan.equals("Admin")) {
			bonus = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < arrayKode.size(); i++) {
				if (arrayJabatan.get(i).equals("Admin")) {
					bonus = bonus + arrayKode.get(i) + " ";
				}
			}
		System.out.println(bonus);
		}
		
		if (arrayJabatanManager.size() % 3 == 0) {
			for (int i = 0; i < arrayJabatanManager.size(); i++) {
				arrayGaji.set(i, (arrayGaji.get(i) + (gaji * 10/100)));
			}
		}
			
		if (arrayJabatanSupervisor.size() % 3 == 0) {
			for (int i = 0; i < arrayJabatanSupervisor.size(); i++) {
				arrayGaji.set(i, (arrayGaji.get(i) + (gaji * 75/1000)));
			}
		}
		
		if (arrayJabatanAdmin.size() % 3 == 0) {
			for (int i = 0; i < arrayJabatanAdmin.size(); i++) {
				arrayGaji.set(i, (arrayGaji.get(i) + (gaji * 5/100)));
			}
		}
		System.out.println(" ");
		mainMenu();
	}

	public void viewData() {
		if (arrayNama.isEmpty()) {
			System.out.println("Tidak ada data!");
			System.out.println(" ");
			mainMenu();
		}

		else if (!arrayNama.isEmpty()) {
			for (int i = 0; i < arrayNama.size() - 1; i++) {
				for (int j = i + 1; j < arrayNama.size(); j++) {
					if (arrayNama.get(i).compareToIgnoreCase(arrayNama.get(j)) > 0) {
						tempKode = arrayKode.get(i);
						arrayKode.set(i, arrayKode.get(j));
						arrayKode.set(j, tempKode);

						tempNama = arrayNama.get(i);
						arrayNama.set(i, arrayNama.get(j));
						arrayNama.set(j, tempNama);

						tempKelamin = arrayKelamin.get(i);
						arrayKelamin.set(i, arrayKelamin.get(j));
						arrayKelamin.set(j, tempKelamin);
						
						tempJabatan = arrayJabatan.get(i);
						arrayJabatan.set(i, arrayJabatan.get(j));
						arrayJabatan.set(j, tempJabatan);
						
						tempGaji = arrayGaji.get(i);
						arrayGaji.set(i, arrayGaji.get(j));
						arrayGaji.set(j, tempGaji);
					}
				}
			}
		}
		for (int i = 0; i < arrayNama.size(); i++) {
			System.out.println("(" + (i + 1) + ")");
			System.out.println("Kode Karyawan : " + arrayKode.get(i));
			System.out.println("Nama Karyawan : " + arrayNama.get(i));
			System.out.println("Jenis Kelamin : " + arrayKelamin.get(i));
			System.out.println("Jabatan       : " + arrayJabatan.get(i));
			System.out.println("Gaji Karyawan : " + arrayGaji.get(i));
			System.out.println(" ");
		}
		mainMenu();
	}

	public void updateData() {
		if (arrayNama.isEmpty()) {
			System.out.println("Tidak ada data!");
			System.out.println(" ");
			mainMenu();
		}

		else if (!arrayNama.isEmpty()) {
			for (int i = 0; i < arrayNama.size() - 1; i++) {
				for (int j = i + 1; j < arrayNama.size(); j++) {
					if (arrayNama.get(i).compareToIgnoreCase(arrayNama.get(j)) > 0) {
						tempKode = arrayKode.get(i);
						arrayKode.set(i, arrayKode.get(j));
						arrayKode.set(j, tempKode);

						tempNama = arrayNama.get(i);
						arrayNama.set(i, arrayNama.get(j));
						arrayNama.set(j, tempNama);

						tempKelamin = arrayKelamin.get(i);
						arrayKelamin.set(i, arrayKelamin.get(j));
						arrayKelamin.set(j, tempKelamin);
						
						tempJabatan = arrayJabatan.get(i);
						arrayJabatan.set(i, arrayJabatan.get(j));
						arrayJabatan.set(j, tempJabatan);
						
						tempGaji = arrayGaji.get(i);
						arrayGaji.set(i, arrayGaji.get(j));
						arrayGaji.set(j, tempGaji);
					}
				}
			}
		}
		for (int i = 0; i < arrayNama.size(); i++) {
			System.out.println("(" + (i + 1) + ")");
			System.out.println("1. Kode Karyawan : " + arrayKode.get(i));
			System.out.println("2. Nama Karyawan : " + arrayNama.get(i));
			System.out.println("3. Jenis Kelamin : " + arrayKelamin.get(i));
			System.out.println("4. Jabatan       : " + arrayJabatan.get(i));
			System.out.println("5. Gaji Karyawan : " + arrayGaji.get(i));
			System.out.println(" ");
		}
		
		do {
			System.out.print("Input Angka Dari List Data Yang Ingin di Update : ");
			System.out.println(" ");
			try {
				angkaUpdate = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				angkaUpdate = -1;
				scanner.nextLine();
			}
		} while (angkaUpdate < 1 || angkaUpdate > arrayNama.size());
		
		do {
			System.out.print("Input Nama Karyawan [>= 3] : ");
			nama = scanner.nextLine();
		} while (nama.length() < 3);
		
		do {
			System.out.print("Input Jenis Kelamin [Laki-Laki | Perempuan] (Case Sensitive) : ");
			kelamin = scanner.nextLine();
		} while (!kelamin.equals("Laki-Laki") && !kelamin.equals("Perempuan"));
		
		do {
			System.out.print("Input Jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
			jabatan = scanner.nextLine();
		} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		
			if (jabatan.equals("Manager")) {
				gaji = 8000000;
			}
		
			else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
			}
		
			else if (jabatan.equals("Admin")) {
				gaji = 4000000;
			}
		
		Random random = new Random();
		ID = "" + (char) (random.nextInt(26) + 'A') + (char) (random.nextInt(26) + 'A') + "-" + (random.nextInt(10)) + (random.nextInt(10)) + (random.nextInt(10)) + (random.nextInt(10));
		System.out.println("Berhasil menambahkan karyawan dengan id " + ID);
		System.out.println(" ");
		
		arrayKode.set((angkaUpdate - 1), ID);
		arrayNama.set((angkaUpdate - 1), nama);
		arrayKelamin.set((angkaUpdate - 1), kelamin);
		arrayJabatan.set((angkaUpdate - 1), jabatan);
		arrayGaji.set((angkaUpdate - 1), gaji);
		
		if (arrayJabatanManager.size() >= 3 || arrayJabatanManager.size() % 3 == 0 && jabatan.equals("Manager")) {
			bonus = "Bonus sebesar 10% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < arrayKode.size(); i++) {
				if (arrayJabatan.get(i).equals("Manager")) {
					bonus = bonus + arrayKode.get(i) + " ";
				}
			}
		System.out.println(bonus);
		}
		
		if (arrayJabatanSupervisor.size() >= 3 || arrayJabatanManager.size() % 3 == 0&& jabatan.equals("Supervisor")) {
			bonus = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < arrayKode.size(); i++) {
				if (arrayJabatan.get(i).equals("Supervisor")) {
					bonus = bonus + arrayKode.get(i) + " ";
				}
			}
		System.out.println(bonus);
		}
		
		if (arrayJabatanAdmin.size() >= 3 || arrayJabatanManager.size() % 3 == 0 && jabatan.equals("Admin")) {
			bonus = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			System.out.println(" ");
			for (int i = 0; i < arrayKode.size(); i++) {
				if (arrayJabatan.get(i).equals("Admin")) {
					bonus = bonus + arrayKode.get(i) + " ";
				}
			}
		System.out.println(bonus);
		}
		
		if (arrayJabatanManager.size() % 3 == 0) {
			for (int i = 0; i < arrayJabatanManager.size(); i++) {
				arrayGaji.set(i, (arrayGaji.get(i) + (gaji * 10/100)));
			}
		}
			
		if (arrayJabatanSupervisor.size() % 3 == 0) {
			for (int i = 0; i < arrayJabatanSupervisor.size(); i++) {
				arrayGaji.set(i, (arrayGaji.get(i) + (gaji * 75/1000)));
			}
		}
		
		if (arrayJabatanAdmin.size() % 3 == 0) {
			for (int i = 0; i < arrayJabatanAdmin.size(); i++) {
				arrayGaji.set(i, (arrayGaji.get(i) + (gaji * 5/100)));
			}
		}
		mainMenu();
	}

	public void deleteData() {
		if (arrayNama.isEmpty()) {
			System.out.println("Tidak ada data!");
			System.out.println(" ");
			mainMenu();
		}

		else if (!arrayNama.isEmpty()) {
			for (int i = 0; i < arrayNama.size() - 1; i++) {
				for (int j = i + 1; j < arrayNama.size(); j++) {
					if (arrayNama.get(i).compareToIgnoreCase(arrayNama.get(j)) > 0) {
						tempKode = arrayKode.get(i);
						arrayKode.set(i, arrayKode.get(j));
						arrayKode.set(j, tempKode);

						tempNama = arrayNama.get(i);
						arrayNama.set(i, arrayNama.get(j));
						arrayNama.set(j, tempNama);

						tempKelamin = arrayKelamin.get(i);
						arrayKelamin.set(i, arrayKelamin.get(j));
						arrayKelamin.set(j, tempKelamin);
						
						tempJabatan = arrayJabatan.get(i);
						arrayJabatan.set(i, arrayJabatan.get(j));
						arrayJabatan.set(j, tempJabatan);
						
						tempGaji = arrayGaji.get(i);
						arrayGaji.set(i, arrayGaji.get(j));
						arrayGaji.set(j, tempGaji);
					}
				}
			}
		}
		for (int i = 0; i < arrayNama.size(); i++) {
			System.out.println("(" + (i + 1) + ")");
			System.out.println("1. Kode Karyawan : " + arrayKode.get(i));
			System.out.println("2. Nama Karyawan : " + arrayNama.get(i));
			System.out.println("3. Jenis Kelamin : " + arrayKelamin.get(i));
			System.out.println("4. Jabatan       : " + arrayJabatan.get(i));
			System.out.println("5. Gaji Karyawan : " + arrayGaji.get(i));
			System.out.println(" ");
		}
		
		do {
			System.out.print("Input Angka Dari List Data Yang Ingin di Delete : ");
			System.out.println(" ");
			try {
				angkaDelete = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				angkaDelete = -1;
				scanner.nextLine();
			}
		} while (angkaDelete < 1 || angkaDelete > arrayNama.size());
		
		arrayKode.remove(angkaDelete - 1);
		arrayNama.remove(angkaDelete - 1);
		arrayKelamin.remove(angkaDelete - 1);
		arrayJabatan.remove(angkaDelete - 1);
		arrayGaji.remove(angkaDelete - 1);
		mainMenu();
	}

	public static void main(String[] args) {
		new Main();

	}
}
