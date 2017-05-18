pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }
    stage('Report') {
      steps {
        junit '**/target/surefire-reports/TEST-*.xml'
      }
    }
    stage('Package') {
      steps {
        sh 'docker ps'
      }
    }
  }
  tools {
    maven 'apache-maven-3.5.0'
  }
}