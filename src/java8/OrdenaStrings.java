package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("BRQ Soluções Digitais");
		palavras.add("AWS Foundation");
		palavras.add("NUBE Estágio");
		
		// 1. Compara o length das palavras (lambda)
		palavras.sort((s1, s2)->{
			if(s1.length() < s2.length())
				return -1;
			if(s1.length() > s2.length())
				return 1;
			return 0;
		});
		
		// 2. Compara o length das palavras (lambda)
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		// 3. Compara o length das palavras (lambda)
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		// 4. Compara o length das palavras (lambda)
		palavras.sort(Comparator.comparing(String::length)); 
		
		// Outras formas de utilizar lambda
		Function<String, Integer>funcao = String::length; //method reference
		Function<String, Integer>funcao2 = s -> s.length();
		Comparator<String>comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		
		// Chamando lambda por classe anônima
		Consumer<String> impressor = s -> System.out.println(s);
		Consumer<String> impressor2 = System.out::println; //method reference

		palavras.forEach(impressor);
		palavras.forEach(impressor2);

		
		// Imprimi na tela
		System.out.println(palavras);

		// Imprimi cada palavra (lambda)
		palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println); //method reference

		
		// Testando um Runnable (lambda)
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
		List<Double> numero = new ArrayList<Double>();
		numero.add(26.60);
		numero.add(97.65);
		
		// Somando numeros (lambda)
		double sum = numero.stream().mapToDouble(n -> n).sum();
		System.out.println(sum);
				
	}
}

//class ImprimiNaLinha implements Consumer<String>{
//
//	@Override
//	public void accept(String s) {
//		System.out.println(s);		
//	}
//	
//}

//class ComparadorPorTamanho implements Comparator<String> {
//
//	@Override
//	public int compare(String s1, String s2) {
//		if (s1.length() < s2.length()) {
//			return -1;
//		}
//		if (s1.length() > s2.length()) {
//			return 1;
//		}
//		return 0;
//	}
//
//}