pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn install'
      }
    }
    stage('Report') {
      steps {
        junit '**/target/surefire-reports/*.xml'
      }
    }
    stage('Package') {
      when {
        expression {
          currentBuild.result == null || currentBuild.result == 'SUCCESS' 
        }
      }
      steps {
        sh 'mvn docker:build'
      }
    }
  }
  tools {
    maven 'apache-maven-3.5.0'
  }
}
