# Task Management App Spring Boot

sebuah aplikasi berbasis Java menggunakan framework `SpringBoot` untuk demonstrasi penggunaan SonarQube.

Kasus :
akan maintain kode _existing_ dengan menambahkan fitur _login_.

## Cara Menjalankan

1. Melakukan instalasi
dijalankan pertama kali untuk download library
```bash
./mvnw clean install
```

2. Jalankan
```bash
./mvnw spring-boot:run
```

1b.
```
./mvnw compile
```
tanpa melakukan unit test

3. Kirim / Test API lewat `postman`


3.1 Generate token
![generate-token](./img/generate-token.png)

3.2 Validasi token
![validasi-token-seharusnya](./img/validasi-token-seharusnya.png)

![validasi-token-saat-ini](./img/validasi-token-saat-ini.png)

4. Maintain kode menggunakan SonarQube

![maintain-kode-dengan-sonarQube](./img/maintain-kode-dengan-sonarQube.png)

![cek-di-jwt-io](./img/cek-di-jwt-io.png)
