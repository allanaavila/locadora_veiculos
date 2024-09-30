## Aplicação dos Princípios Aprendidos no Módulo

Neste projeto, aplicamos os princípios SOLID para garantir que o código seja modular, escalável e de fácil manutenção. A seguir, detalhamos como cada princípio foi implementado.

### Princípios SOLID Aplicados

- **Single Responsibility Principle (SRP)**: Cada classe possui uma responsabilidade única e bem definida. Por exemplo, a classe `Agencia` é responsável apenas por encapsular os dados de uma agência, enquanto a classe `AgenciaServico` lida com a lógica de negócio referente à manipulação dessas agências. Essa divisão facilita a manutenção e a expansão do código.

- **Open/Closed Principle (OCP)**: Este princípio foi aplicado ao manter as classes, como `AgenciaServicoImplementacao`, abertas para extensão, mas fechadas para modificação. Isso é feito por meio do uso de interfaces e herança, permitindo que novas funcionalidades sejam adicionadas sem alterar o código existente, mantendo a integridade do sistema.

- **Liskov Substitution Principle (LSP)**: Garantimos que subclasses, como `PessoaFisica` e `PessoaJuridica`, possam ser usadas de forma intercambiável com a classe base `Pessoa` sem comprometer a funcionalidade do sistema. Isso permite o uso seguro de polimorfismo, sem causar comportamentos inesperados no código.

- **Interface Segregation Principle (ISP)**: O projeto seguiu o ISP ao dividir as interfaces em partes coesas e específicas para suas funções. Por exemplo, as interfaces de repositório e serviço foram segregadas para que as classes implementem apenas os métodos relevantes às suas responsabilidades. Isso torna o código mais limpo e fácil de entender.

- **Dependency Inversion Principle (DIP)**: Embora o DIP não tenha sido implementado diretamente com o uso de frameworks de injeção de dependências como Spring, aplicamos esse princípio de forma indireta por meio da utilização de interfaces em nossos serviços e repositórios. Por exemplo, o serviço de `AluguelServico` e seus repositórios dependem de abstrações (`AgenciaRepositorio`, `PessoaRepositorio`), permitindo que a lógica de negócios dependa de contratos e não de implementações concretas. Isso prepara o código para ser facilmente adaptado para uma inversão de controle mais robusta em uma fase futura do projeto.
