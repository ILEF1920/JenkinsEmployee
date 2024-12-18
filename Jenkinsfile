pipeline {
    agent any
    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }
        stage('Build Backend') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('Run Backend Tests') {
            steps {
                sh './mvnw test'
                junit 'target/surefire-reports/*.xml'
            }
        }
        stage('Build Frontend') {
            steps {
                sh 'npm install'
                sh 'ng build --prod'
            }
        }
        stage('Run E2E Tests') {
            steps {
                sh 'npm run e2e'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit 'target/surefire-reports/*.xml'
        }
    }
}
