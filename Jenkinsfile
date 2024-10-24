pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clona il repository GitHub
                git credentialsId: 'e8c8f201-a6b7-4d81-80f1-208e452d0775', url: 'https://github.com/xtmms/frameworkTA.git'
            }
        }

        stage('Build') {
            steps {
                // Compila il progetto Maven e risolvi le dipendenze
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                // Esegui la suite TestNG specificata nel file XML
                sh 'mvn test -DsuiteXmlFile=src/test/java/suite/xml/example.xml'
            }
        }

        stage('Generate Allure Report') {
            steps {
                // Genera i report Allure
                sh 'mvn allure:report'
            }
        }

        stage('Publish Allure Report') {
            steps {
                // Pubblica i report Allure su Jenkins
                allure includeProperties: false, results: [[path: 'allure-results']]
            }
        }
    }

    post {
        success {
            // Notifica in caso di successo
            echo 'TestNG suite eseguita con successo e Allure report generato!'
        }
        failure {
            // Notifica in caso di fallimento
            echo 'La suite di test TestNG ha fallito!'
        }
        always {
            // Pulisce il workspace
            cleanWs()
        }
    }
}
