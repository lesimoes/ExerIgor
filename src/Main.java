import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		
        byte opc;
        
        ArrayList<Funcionario> funcs = new ArrayList<Funcionario>();
        
        Scanner sc = new Scanner(System.in);
        
        do
        {
            System.out.print("\n----------Aplicação----------");
            System.out.print("\nO que deseja fazer (1 - Cadastrar / 2 - Consultar / 3 - Remover / 0 - Sair)? ");
            
            opc = sc.nextByte();
            
            if (opc == 1)
            {
                
                String cpf;
                String matricula;
                String nome;
                String cargo;
                float salario;
                
                System.out.print("\n-----Cadastro de funcionário-----\n");
                
                System.out.print("Nome: ");
                
                nome = sc.next();
                
                sc.nextLine();
                
                System.out.print("Cargo: ");
                
                cargo = sc.next();
                
                System.out.print("Salario: ");
                
                salario = sc.nextFloat();
                
                System.out.print("CPF: ");
                
                cpf = sc.next();
                
                System.out.print("Matricula: ");
                
                matricula = sc.next();
                
                funcs.add(new Funcionario(cpf, matricula, nome, salario, cargo));
                
                System.out.print("\nCadastro realizado com sucesso\n");
            }
            
            if (opc == 2)
            {
                String consulta;
                
                if (funcs.isEmpty())
                {
                    System.out.print("\nNenhum funcionário cadastrado no sistema\n");
                }
                
                if (!(funcs.isEmpty()))
                {
                    System.out.print("\n-----Consulta de funcionário-----\n");
                
                    System.out.print("Digite o CPF do requisitado: ");
                
                    consulta = sc.next();
                
                    for (int i = 0; i < funcs.size(); i ++)
                    {
                        if (funcs.get(i).compareCPF(consulta))
                        {
                            System.out.print(funcs.get(i).ToString());
                        }
                    }
                }
            }
            
            if (opc == 3)
            {
                String consulta;
                    
                System.out.print("\n-----Remoção de funcionário-----\n");
                
                System.out.print("Digite o CPF do requisitado: ");
                
                consulta = sc.next();
                
                for (int i = 0; i < funcs.size(); i ++)
                {
                    if (funcs.get(i).obterCPF().equals(consulta))
                    {
                        funcs.remove(i);
                    }
                }
            }
            
            if (opc == 0)
            {
                System.out.print("Saindo...");
                
                break;
            }
             
        } while(opc > 0 && opc < 4);
        
        sc.close();
    }
		
}

