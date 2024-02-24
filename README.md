# Tutorial 1
## Reflection 1
### Penerapan Clean Code
Pada tutorial kali ini, saya menerapkan Clean Code dengan cara memberikan nama dan penulisan yang jelas pada variabel, class, dan method. Saya juga menggunakan indentasi yang jelas pada penulisan kode sehingga terlihat rapi. Saya juga menerapkan prinsip OOP dengan baik dan penggunaan fungsi untuk menghindari kode repetitif. Untuk pengembangan kode agar lebih baik adalah dengan menambahkan komentar yang cukup dan jelas, karena pada code web app tutorial 1 ini saya kurang menuliskan komentar pada setiap method yang saya buat. 
### Penerapan Secure Coding
Penerapan Secure coding pada tutorial 1 ini masih kurang dengan belum adanya autentikasi dan otorisasi pada aplikasi yang saya buat. Saya juga belum menggunakan enkripsi pada password yang disimpan pada database. Untuk pengembangan kode agar lebih baik adalah dengan menambahkan autentikasi dan otorisasi pada aplikasi yang dibuat. Pada web app ini sudah ada form dan saya juga belum mendalami web app dengan spring security, sehingga saya belum yakin dengan keamanan aplikasi yang saya buat untuk serangan seperti SQL Injection / XSS.
## Reflection 2
### Testing dan Code Coverage
Untuk memastikan bahwa unit test yang dibuat cukup dalam menguji program kita adalah dengan menggunakan berbagai test case yang mungkin menyebabkan program error. Setelah melakukan testing, tentu saya lebih yakin dengan kebenaran fungsionalitas aplikasi yang saya buat. Namun, saya belum sepenuhnya yakin karena code coverage web app yang saya buat belum diuji. Setau saya, code coverage adalah proses pengujian yang digunakan untuk menentukan sejauh mana kode program yang diuji. Code coverage 100% tidak berarti kode tidak memiliki bugs dan error. Karena bisa saja error seperti logic terjadi pada aplikasi dan tidak terdeteksi oleh code coverage.
### Functional Test dan Code Quality
Dengan membuat functional test dengan aturan prosedur dan variabel yang sama dengan sebelumnya, akan menyebabkan kode yang repetitif pada page yang berbeda yang mana menantang prinsip Clean Code. Hal ini juga saya alami sebelumnya saat membuat beberapa functional test dengan logic yang sama pada page yang berbeda.

# Tutorial 2
## Reflection
### Fix Code Quality
Pada tutorial 2 ini, saya memperbaiki code quality saya dengan melakukan full unit testing pada seluruh fungsi yang dibuat pada aplikasi. Code coverage pada kode yang telah dibuat sudah menjadi 100%. Saya juga memperbaiki penggunaan _access modifiers_ pada kode saya sehingga digunakan secara sesuai pada fungsi dan variabel yang dibuat.
### CI/CD
Pada tutorial 2 ini, saya juga menerapkan CI/CD (Continuous Integration dan Deployment) dengan menggunakan Github Actions. CI/CD adalah proses otomatisasi yang memungkinan developer untuk mengintegrasikan kode ke dalam repository secara berkala dan mengotomatisasi proses pembangunan, pengujian, dan pengiriman aplikasi ke server produksi. Dengan menerapkan CI/CD, saya dapat memastikan bahwa kode yang saya buat dapat diintegrasikan dengan baik dan dapat di-deploy ke server produksi dengan cepat dan aman. Saya menerapkan CI dengan menjalankan workflow unit testing serta workflow analisis kode pada SonarCloud dan workflow pemindaian keamanan kode pada OSSF Scorecard setiap melakukan push ke Github. Saya juga menerapkan CD dengan melakukan deploy aplikasi ke Koyeb setiap kali melakukan push ke branch main.

# Tutorial 3
## Reflection
### Principles Aplied
- Single Responsibility Principle (SRP) : Membuat CarController class baru dibandingkan menggabungkannya dengan ProductController dengan extends. Hal ini saya lakukan karena input dan return value dari kedua class tersebut yang beda walaupun perilakunya sama.
- Open-Closed Principle (OCP) : Pada kode ini saya menganggap Car dan Product adalah dua hal yang berbeda. Sehingga tidak ada extends class pada kode ini karena tidak ada kebutuhan modifikasi dengan extends terhadap suatu class.
- Liskov Substitution Principle (LSP) : Karena saya menganggap Car dan Product hal yang berbeda, sehingga tidak ada extends dan tidak diperlukan inheritance sifat antar class pada kode ini.
- Interface Segregation Principle (ISP) : Kode ini sudah menerapkan ISP dengan memisahkan interface Car dan Product, hal ini dilakukan karena keduanya memiliki input yang berbeda pada method masing-masing walaupun perilakunya sama.
- Dependency Inversions Principle (DIP) : Kode ini sudah menerapkan DIP dimana hanya melakukan reference Controllers terhadap interface dari Service daripada class Service sendiri.
### Advantages Applying SOLID
Menerapkan prinsip SOLID dalam proyek dapat menghasilkan kode yang lebih modular, rapih, mudah dipelihara, dan diperluas. Prinsip-prinsip ini membantu mengurangi dampak perubahan, mengurangi penggabungan antar komponen, dan menyempurnakan desain perangkat lunak secara keseluruhan.
### Disadvantages Not Applying SOLID
Tidak menerapkan prinsip SOLID pada suatu proyek dapat menimbulkan berbagai kerugian, termasuk kode yang lebih sulit dipelihara, kurang fleksibel, dan lebih rentan terhadap bug. Misalnya, pelanggaran Single Responsibility Principle (SRP) dengan memiliki kelas dengan banyak tanggung jawab dapat mengakibatkan kode yang kusut dan sulit dipahami, sehingga membuat pemeliharaan menjadi sulit. Kegagalan untuk mematuhi Open-Closed Principle (OCP) dapat menyebabkan modifikasi kode yang berisiko menimbulkan kesalahan pada fungsi yang ada. Mengabaikan Liskov Substitution Principle (LSP) dapat menyebabkan perilaku tidak terduga saat mengganti kelas turunan dengan kelas dasar. Jika Interface Segregation Principle (ISP) diabaikan, klien mungkin terpaksa menerapkan metode yang tidak perlu, sehingga menciptakan ketergantungan yang menghambat fleksibilitas. Selain itu, tidak mengikuti Dependency Inversion Principle (DIP) dapat mengakibatkan modul tingkat tinggi digabungkan secara erat dengan modul tingkat rendah, sehingga lebih sulit untuk beradaptasi terhadap perubahan ketergantungan. Secara keseluruhan, mengabaikan prinsip-prinsip SOLID dapat menyebabkan kurangnya pemeliharaan, skalabilitas, dan ketahanan dalam proyek perangkat lunak.
