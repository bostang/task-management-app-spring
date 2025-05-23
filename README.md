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


Melakukan Integrasi SonarQube dengan `Github action`:
![analysis-method](./img/analysis-method.png)


# Cara store credential di tempat yang tepat
➡️Github

sonar token ➡️ untuk akses sonarQube.

github selain menjadi repository juga sebagai secret manager.

Administration > Analysis Method

![sonar-cloud-Github-Analyze](./img/sonar-cloud-Github-Analyze.png)

![github-setting-secret](./img/github-setting-secret.png)

pilih **New Repository secret**

![github-storing-secret](./img/github-storing-secret.png)

![information-project-key](./img/information-project-key.png)


setelah build, di actions ada error apabila `dependency graph` belum di-_enable_.
![advanced-security-dependency-graph](./img/advanced-security-dependency-graph.png)