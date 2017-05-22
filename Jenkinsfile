pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn install -Dmaven.test.failure.ignore=true install'
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
        sh 'mvn docker:build -DpushImage'
      }
    }
    stage('Integration') {
      environment {
        RANCHER_ACCESS_KEY = credentials('RANCHER_ACCESS_KEY')
        RANCHER_SECRET_KEY = credentials('RANCHER_SECRET_KEY')
        RANCHER_URL = 'http://rancher-server.dev.gc.com/'
      }
      steps {
        sh 'rancher-compose -p stack1 up --upgrade -d'
      }
    }
    stage('Jmeter') {
      steps {
        dir(path: 'myapp-test') {
          sh 'ls -l'
        }
        
      }
    }
  }
  tools {
    maven 'apache-maven-3.5.0'
  }
}