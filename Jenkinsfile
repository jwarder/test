pipeline {
    agent any
    tools {
        maven 'apache-maven-3.5.0' 
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
        }
        stage('Report') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Package') {
            steps {
                sh 'docker ps'
            }
        }
    }
}
