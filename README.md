# TP2DPBO2024C2

## Janji
Saya Jasmine Noor Fawzia [2200598] mengerjakan soal TP2 dalam Mata Kuliah DPBO
untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan
Aamiin

## Desain Program
**1. Database.java**

Kelas ini bertanggung jawab untuk proses interaksi dengan database MySQL. Memiliki metode untuk melakukan query SELECT, INSERT, UPDATE, dan DELETE serta menggunakan JDBC untuk berkomunikasi dengan database.

**2. Mahasiswa.java**

Kelas ini merupakan representasi objek dari data mahasiswa yang memiliki atribut NIM, nama, jenis kelamin, dan status mahasiswa untuk data mahasiswa, serta terdapat getter dan setter untuk mengakses dan memodifikasi atribut.

**3. Menu.java**

Kelas ini merupakan kelas utama yang mengatur antarmuka pengguna (UI). Menampilkan jendela utama dengan tabel untuk menampilkan data mahasiswa. Memiliki field untuk input data mahasiswa seperti NIM, nama, jenis kelamin, dan status. Terdapat tombol untuk menambah, mengubah, dan menghapus data mahasiswa. Mengimplementasikan fungsi-fungsi untuk memproses operasi CRUD pada data mahasiswa yang akan berkaitan dengan database.

## Penjelasan Alur
Saat program dijalankan, jendela utama akan ditampilkan. Tabel akan diisi dengan data mahasiswa yang ada di database. Beberapa button seperti "Add", "Update", dan "Delete" akan siap digunakan. Pengguna memasukkan data mahasiswa baru melalui input field, SQL yang digunakan adalah _INSERT INTO mahasiswa VALUES_. Saat tombol "Add" ditekan, data akan dimasukkan ke dalam database dan tabel akan diperbarui untuk menampilkan data terbaru. Namun, jika ada input yang kosong atau NIM yang sudah ada, akan ditampilkan prompt error. Pengguna memilih salah satu baris data pada tabel untuk diubah. Data terpilih akan ditampilkan kembali di input field dan pengguna akan melakukan perubahan pada data tersebut, SQL yang dipakai yaitu _UPDATE mahasiswa SET_. Saat tombol "Update" ditekan, data yang diubah akan disimpan ke dalam database dan tabel akan diperbarui untuk menampilkan perubahan. Ketika sedang melakukan perubahan terdapat perubahan yang fieldnya kosong atau NIM yang diubah ternyata sudah ada dalam database, maka akan menampilkan prompt error. Pengguna memilih salah satu baris data pada tabel untuk dihapus dengan SQL DELETE FROM mahasiswa WHERE. Saat tombol "Delete" ditekan, pengguna akan diminta konfirmasi untuk meyakinkan akan menghapus data atau tidak. Jika konfirmasi positif (Ya), data yang dipilih akan dihapus dari database. Tabel akan diperbarui untuk mencerminkan perubahan. Saat pengguna memilih salah satu baris dan menampilkan data tersebut di input field, SQL yang digunakan adalah SELECT * FROM mahasiswa.

## Dokumentasi Program saat Dijalankan
1. Proses Insert Data

![1  error field kosong](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/b0b21f93-670e-4560-be2e-d9ff0eef447b)
![2  error nim sama](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/d77ffbb0-7838-4232-a3e6-aea0d63837c1)
![3  berhasil insert](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/699aee3b-cb15-40b1-9323-fa78188e044d)
![4  masuk database](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/cc4a086b-2af9-493f-8837-f1ad127e2986)

2. Proses Update Data

![1  select](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/30ddd9d1-c0d1-46ee-bf86-a1b819676ec6)
![2  error field kosong](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/38d6ddd4-4c32-445c-b75a-7348f6a9d922)
![3  error nim sama](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/634684e4-8284-4528-a651-31bbe07a22b6)
![4  berhasil update](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/30e97e24-08de-4426-97c9-2d3f95197bcb)

3. Proses Delete Data

![1  select](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/768309d2-37c7-4191-8564-8b888524292d)
![2  alert](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/5b7745b5-621d-41d9-88c2-d1952a12c523)
![3  berhasil delete](https://github.com/jasminefwz/TP2DPBO2024C2/assets/147362810/19a2668d-4329-4a08-81a0-7e7273e1e8ad)
