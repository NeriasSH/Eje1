pipeline {
    agent any
    stages {
        stage('Clonar Repositorio') {
            steps {
                git branch: 'main', url: 'https://github.com/NeriasSH/Eje1.git'
            }
        }
        stage('Construir Aplicación') {
            steps {
                bat './mvnw.cmd clean package'
            }
        }
        stage('Ejecutar Aplicación') {
            steps {
                bat 'java -jar target/eje1-0.0.1-SNAPSHOT.jar'  // Ajusta la ruta si es necesario
            }
        }
    }
}
