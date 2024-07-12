package com.example.litualura.principal;

import com.example.litualura.model.Authors;
import com.example.litualura.model.Books;
import com.example.litualura.model.BooksData;
import com.example.litualura.repository.BooksRepository;
import com.example.litualura.service.ConsumeApi;
import com.example.litualura.service.ConverterData;
import com.example.litualura.service.ConverterLanguage;

import java.awt.print.Book;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Principal {

    private final BooksRepository repository;
    private final  String ApiUrl = "https://gutendex.com/books/?search=";

    Scanner scanner = new Scanner(System.in);
    ConsumeApi api = new ConsumeApi();
    ConverterLanguage language = new ConverterLanguage();
    ConverterData data = new ConverterData();

    public Principal(BooksRepository repository) {
        this.repository = repository;
    }

    public void print(){
        var option = -1;
        while(option != 0) {

            var menu = """
                    1 - Busca de livros por títulos
                    2 - Listar todos os livros Registrados
                    3 - Buscar por Idiomas
                    4 - Listar todos os  autores Registrados
                    5 - Listar autores vivos em determinado ano.
                                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 :
                    searchBooksbyTitle();
                    break;
                case 2 :
                    listAllBooks();
                    break;
                case 3 :
                    searchbyLanguage();
                    break;
                case 4 :
                    listAllAuthors();
                    break;
                case 5 :
                    listLivingAuthorsGivingYears();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }

    }

    public void searchBooksbyTitle(){
        System.out.println("Digite o Título do livro :");
        var nameBook = scanner.nextLine();
        String ulrSearch = ApiUrl.concat(nameBook.replace(" ", "+").toLowerCase().trim());

        var json = api.getData(ulrSearch);
        var jsonData =  data.getJson(json,"results");

        List<BooksData> bookList = data.getList(jsonData, BooksData.class);

        if(bookList.size() > 0){
            Books books = new Books(bookList.get(0));

            Authors author = repository.findAuthorByName(books.getAuthor().getName());
            if (author != null) {
                books.setAuthor(null);
                repository.save(books);
                books.setAuthor(author);
            }
            books = repository.save(books);
            System.out.println(books);
        }else{
            System.out.println("Livro Não Encontrado!");
        }
    }

    public void listAllBooks(){
        List<Books> books = repository.findAll();
        books.forEach(System.out::println);
    }

    public void searchbyLanguage(){
        System.out.println("Digite o idioma que deseja encontrar:");
        var languageDta = language.ConverterLanguage(scanner.nextLine());

        List<Books> books = repository.findBooksByLanguages(languageDta);
        if(!books.isEmpty()){
            books.forEach(System.out::println);
        }else{
            System.out.printf("Não a livro nesse idioma",languageDta);
        }
    }
    public void listAllAuthors(){
        List<Authors> authors = repository.searchAuthors();
        authors.forEach(System.out::println);
    }

    public void listLivingAuthorsGivingYears(){
       try{
           System.out.println("Digite o ano que deseja : ");
           var year = scanner.nextInt();
           scanner.nextLine();

           List<Authors> authors = repository.searchLivingAuthors(year);
           authors.forEach(System.out::println);
       }catch(InputMismatchException e ){
           System.out.println("Valor Inválido, Por favor digite corretamente.");
           scanner.nextLine();
        }
    }

}
