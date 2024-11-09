pipeline {
    agent any
    stages {
        stage('Clonar Repositorio') {
            steps {
                git 'https://github.com/NeriasSH/Eje1.git'
            }
        }
        stage('Construir Aplicación') {
            steps {
                bat './mvnw clean package -DskipTests'  // Si usas Maven Wrapper
                // o
                // sh 'mvn clean package' // Si tienes Maven instalado
            }
        }
        stage('Ejecutar Aplicación de Escritorio') {
            steps {
                sh 'java -jar target/eje1-0.0.1-SNAPSHOT.jar'  // Ajusta la ruta si es necesario
            }
        }
    }
}
