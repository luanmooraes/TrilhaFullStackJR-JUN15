# Usando a imagem base do Ubuntu mais recente e nomeando o estágio como 'build'
FROM ubuntu:latest AS build

# Atualizando a lista de pacotes
RUN apt-get update

# Instalando o OpenJDK 17
RUN apt-get install openjdk-17-jdk -y

# Copiando todos os arquivos do diretório atual para o diretório raiz da imagem
COPY . .

# Instalando o Maven, uma ferramenta de automação de compilação para projetos Java
RUN apt-get install maven -y

# Executando o Maven para limpar build anteriores e compilar o projeto
RUN mvn clean install

# Usando uma imagem base menor e otimizada do OpenJDK 17 para o estágio final
FROM openjdk:17-jdk-slim

# Expondo a porta 8080, onde a aplicação irá ouvir (mais para documentação)
EXPOSE 8080

# Copiando o arquivo JAR gerado no estágio de build para o diretório raiz da imagem final
COPY --from=build /target/api-0.0.1-SNAPSHOT.jar app.jar

# Definindo o comando de entrada para executar a aplicação Java
ENTRYPOINT ["java", "-jar", "app.jar"]