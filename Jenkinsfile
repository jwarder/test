pipeline {
    agent any
    tools {
        maven 'apache-maven-3.5.0' 
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('package') {
            steps {
                sh 'docker ps'
            }
        }
    }
}
