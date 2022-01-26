job('javaappDSL') {
    description('Java Maven App con DSL para el curso de Jenkins')
    scm {
        git('https://github.com/Adastra-THW/jenkinsmaven.git', 'master') { node ->
            node / gitConfigName('adastra')
            node / gitConfigEmail('adastra@thehackerway.com')
        }
    }
    steps {
        maven {
          mavenInstallation('mavenjenkins')
          goals('-B -DskipTests clean package')
        }
        maven {
          mavenInstallation('mavenjenkins')
          goals('test')
        }
        shell('''
          echo "Entrega: Desplegando la aplicación" 
          java -jar "/var/jenkins_home/workspace/javaappDSL/target/my-app-1.0-SNAPSHOT.jar"
        ''')
    }
}
