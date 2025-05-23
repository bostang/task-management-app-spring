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

_compile_ tanpa melakukan _unit test_ sehingga lebih cepat.
```bash
./mvnw compile
```

2. Jalankan program
```bash
./mvnw spring-boot:run
```

3. Kirim / Test API lewat `postman`

3.1 Generate token
![generate-token](./img/generate-token.png)

3.2 Validasi token
seharusnya caranya adalah dengan menaruh sebagai _query parameter_
![validasi-token-seharusnya](./img/validasi-token-seharusnya.png)

namun untuk kesederhanaan demo, _token_ ditaruh di _body_.
![validasi-token-saat-ini](./img/validasi-token-saat-ini.png)

4. Maintain kode menggunakan SonarQube

![maintain-kode-dengan-sonarQube](./img/maintain-kode-dengan-sonarQube.png)

verifikasi di jwt io:
![cek-di-jwt-io](./img/cek-di-jwt-io.png)


Melakukan Integrasi SonarQube dengan `Github action`:
![analysis-method](./img/analysis-method.png)


## Cara store credential di tempat yang tepat
➡️Github

`sonar token` ➡️ untuk akses sonarQube.

Github selain menjadi repository juga sebagai secret manager.

langkah : 
`Administration > Analysis Method > Analyse with Github Action`

![sonar-cloud-Github-Analyze](./img/sonar-cloud-Github-Analyze.png)

simpan sonar token sebagai secret di github :
pilih **New Repository secret**
![github-setting-secret](./img/github-setting-secret.png)


![github-storing-secret](./img/github-storing-secret.png)

![information-project-key](./img/information-project-key.png)

- atur project key di `.github/workflows/build.yml` sesuai arahan di SonarQube
- tambahkan Github action di `pom.xml` 


catatan:
setelah build, di actions ada error apabila `dependency graph` belum di-_enable_.
![advanced-security-dependency-graph](./img/advanced-security-dependency-graph.png)