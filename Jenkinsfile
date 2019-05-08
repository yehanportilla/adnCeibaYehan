pipeline
{  
    agent {
      label 'Slave_Induccion'
    }

     
    options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
    disableConcurrentBuilds()
    }

    tools { 
      jdk 'JDK8_Centos'    
      gradle 'Gradle4.5_Centos'
    }

  
stages{
stage('Checkout') {
  steps{
    echo "------------>Checkout<------------"
    checkout([$​class: 'GitSCM​',
      ​branches: [[name: '*/master']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      ​gitTool: 'Git_Centos',
      submoduleCfg: [],
      userRemoteConfigs: [[​credentialsId: 'GitHub_yehanPortilla', url: 'https://github.com/yehanportilla/adnCeibaYehan.git']]])
  }
}

    stage('Unit Tests') {   
          steps{   
            echo "------------>Unit Tests<------------"
            sh '​gradle --b ./build.gradle test​'  
          }
    }
         
    stage('Integration Tests') {    
       steps {     
         		echo "------------>Integration Tests<------------"
       }
    }

    stage('Static Code Analysis') {    
         	steps{  
         		echo '------------>Análisis de código estático<------------'       
         		withSonarQubeEnv('Sonar') {
         		  sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner-Dproject.settings=sonar-project.properties"
              //sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
            }
          }
     }

    stage('Build') {   
       	steps {     
       		 echo "------------>Build<------------"
       	}
     }   
}
      
  post {
  	   always {   
  		   echo 'This will always run' 
  	   }

       success {   
   	        echo 'This will run only if successful'   
       }

       failure {
            echo 'This will run only if failed'
            mail (to: 'yehan.portilla@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
        }
      
     unstable {   
          echo 'This will run only if the run was marked as unstable'
     }

    changed {   
    	echo 'This will run only if the state of the Pipeline has changed'    
    	echo 'For example, if the Pipeline was previously failing but is now successful'  
    }
  }
}