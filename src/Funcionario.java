import java.sql.Date;
import java.util.InputMismatchException;

public class Funcionario
{
    private String nome;
    private String cpf;
    private String matricula;
    private float salario;
    private String cargo;
    private Date dataCadastro;
    
    Funcionario(String cpf, String matricula, String nome, float salario, String cargo)
    {
        if (isCPF(cpf)) this.cpf = cpf;
        if (validarMatricula(matricula)) this.matricula = matricula;
        if (validarNome(nome)) this.nome = nome;
        if (validarSalario(salario)) this.salario = salario;
        
        this.cargo = cargo;
        
        this.dataCadastro = new Date(0);
    }
    
    public boolean validarNome(String nome)
    {
        if (nome.contains(" ") && nome.matches("a-zA-Z"))
        {
            return true;
        }
        
        return false;
    }
    
    public boolean validarMatricula(String matricula)
    {
        if (matricula.length() == 6 && matricula.matches("a-zA-Z0-9"))
        {
            return true;
        }
            
        return false;
    }
   
    public boolean validarSalario(float salario)
    {
        if (salario > 1.000 && salario <= 5.000)
        {
            return true;
        }
        
        return false;
    }
    
    public boolean isCPF(String cpf)
    {
        
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || 
            cpf.equals("33333333333") ||
            cpf.equals("44444444444") || 
            cpf.equals("55555555555") ||
            cpf.equals("66666666666") || 
            cpf.equals("77777777777") ||
            cpf.equals("88888888888") || 
            cpf.equals("99999999999") ||
            (cpf.length() != 11))
            
            return false;
          
        char dig10, dig11;
        int sm, i, r, num, peso;
          
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try
        {
        
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            
            for (i = 0; i < 9; i ++)
            {
                 
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0    
                // (48 eh a posicao de '0' na tabela ASCII)        
            
                num = (int)(cpf.charAt(i) - 48);
                
                sm += (num * peso);
            
                peso -= 1;
            }
          
            r = 11 - (sm % 11);
            
            if ((r == 10) || (r == 11)) dig10 = '0';
            
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
          
            // Calculo do 2o. Digito Verificador
            
            sm = 0;
            peso = 11;
            
            for(i=0; i<10; i++)
            {
                num = (int)(cpf.charAt(i) - 48);
                sm += (num * peso);
                peso -= 1;
            }
          
            r = 11 - (sm % 11);
            
            if ((r == 10) || (r == 11)) dig11 = '0';
            
            else dig11 = (char)(r + 48);
          
            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) return true;
            
            else return false;
        }
        
        catch (InputMismatchException erro)
        {
            return false;
        }
    }
    
    public String obterCPF()
    {
        return (this.cpf.substring(0, 3) + "." + this.cpf.substring(3, 6) + "." + this.cpf.substring(6, 9) + "-" + this.cpf.substring(9, 11));
    }
    
    public Boolean compareCPF(String cpf)
    {
    	if (this.cpf.equals(cpf)) return true;
    	return false;
    }
    
    public String ToString()
    {
        return ("\nNome: " + this.nome + "\nMatricula: " + this.matricula + "\nCPF: " + this.cpf + "\nCargo: " + this.cargo + "\nSalario: " + this.salario + "\nData e hora do momento do cadastro: " + this.dataCadastro);
    }
}