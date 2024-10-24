pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'e8c8f201-a6b7-4d81-80f1-208e452d0775', url: 'https://github.com/xtmms/frameworkTA.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test -DsuiteXmlFile=src/test/java/suite/xml/example.xml'
            }
        }

        stage('Generate Allure Report') {
            steps {
                bat 'mvn allure:report'
            }
        }

        stage('Publish Allure Report') {
            steps {
                allure includeProperties: false, results: [[path: 'allure-results']]
            }
        }
    }

    post {
        success {
            echo 'TestNG suite eseguita con successo e Allure report generato!'
        }
        failure {
            echo 'La suite di test TestNG ha fallito!'
        }
        always {
            cleanWs()
        }
    }
}
