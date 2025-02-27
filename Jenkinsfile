pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/abhivscode/seleniumJenkins.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Publish Test Reports') {
            steps {
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true,
                    reportDir: 'target/surefire-reports', reportFiles: 'index.html', reportName: 'Test Report'])
            }
        }
    }
}
