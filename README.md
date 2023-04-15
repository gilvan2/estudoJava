# estudoJava
Repositório para estudo e aprendizado

FormacaoJavaOrientacaoObjetos

	FormacaoJavaOrientacaoObjetos
	|-> 11-java8Moderno
	|-> 12-java-testes-unitarios-tdd

	11-java8Moderno
    Nesse módulo foram mostradas as principais novidades do java na versão 8
    Default Methods, Lambdas, Method References, Streams, Mais Streams, Collectors e a nova API de datas
	
	
	
	----------------------------------------------------------------------------------------------------------
	
FormacaoSpringFrameWork 
	Módulo de estudo para implementar e compreender os fundamentos do Springboot e todo o ecossistem envolvido
	O Módulo esta separado na seguinte formatação
	
	FormacaoSpringFrameWork
	|-> 01-JavaServelet
	|-> 01-JavaServelet-ClientWebService
	|-> 02 - JavaJDBC
	|-> 02-loja-virtual-view-repository
	|-> 03 -Persistencia com JPA - Hibernate
	
	01-JavaServelet 
	Deretório que contem uma base boa de um sistema ficticio de um lista de empresas realizando um CRUD básico
	
	Pre-Requisitos
	Java versão 17 +
	Maven versão 3.8.1 +
	Docker 
	
	Primeiro vez que o sistema será executado
	
	Assim que os 3 pré-requisitos estiverem instalados, deve-se seguir os próximos passos.
	
	
	1 - A partir da raiz do projeto onde se encontra o arquivo pom.xml, fazer uma processo de build padrão do maven
		[mvn install]
		Esse passo deve retorna ao final uma mensagem de BUILD SUCESS ao finla do processo
	
	2 - Navegar até o diretório docker do projeto e criar uma imagem baseada no Dockerfile presente
	
		[docker build -t tomcat-gerenciador:1.0 .] Foi solicitado ao docker que uma imagem chamada tomcat-gerenciador na versão 1.0 fosse criada dentro do diretório docker 
		
	3 - Com a imagem criado, iniciar o conteiner expondo um porta que não esta sendo utilizada pelo sistema operacional
		[docker run -it --rm -p 9091:8080 tomcat-gerenciador:1.0]
	
	4 - Descobrir o id do conteiner que foi gerado, depois copie o path do .war que foi gerado no passo 1 para em seguida fazer com que o conteiner gerado copie essa build para dentro do deretório de deploy do tomcat 
	
	[docker ps] Irá fazer uma lista com os os conteiners que estão rodando no momento, identifique o conteiner da imagem tomcat-gerenciador:1.0 ( para exemplificar, o id será o númeor e20ea1e4ef13 )
	[C:/projetos/gilvan/github/estudoJava/FormacaoSpringFrameWork/01-JavaServelet/target/gerenciador-0.0.1-SNAPSHOT.war] Para exemplificar, o arquivo .war esta nesse local
	[docker cp 'C:/projetos/gilvan/github/estudoJava/FormacaoSpringFrameWork/01-JavaServelet/target/gerenciador-0.0.1-SNAPSHOT.war' e20ea1e4ef13:'/usr/local/tomcat/webapps'] Instrução para copiar o arquivo war para o diretório de deploy
	
	5 - Acessar localmente de acordo com porta compartilhada entre a máquina real e o conteiner /nome do arquivo [gerenciador-0.0.1-SNAPSHOT]. Como nesse projeto não existe um arquivo index, acessamos mais o local da funcionalidade + ação 
	[http://localhost:9091/gerenciador-0.0.1-SNAPSHOT/entrada?acao=LoginForm]
	
	6 - Quando um novo deploy for realizado, o passo 4 deve ser executado novamente para as mudanças surtirem efeito no momento de acessar o sistema 
	
	