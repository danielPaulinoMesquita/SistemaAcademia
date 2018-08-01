$(function(){
    
     // Equivale ao Loading da pagina

    $("#modal01").modal({backdrop:false});//tira o fundo peto

    $("#modal01").modal("show")//Abri o modal automaticamente ao carregar a página;

    setTimeout(function(){
        $("#modal01").modal("hide");//Faz a janela modal(ou notificação fechar sozinha)
    },3000);//3000 equivale a 3 seg

    $(".ttp").tooltip({
        animation:false,
        delay:{show:1000, hide:2000},//Show-é o tempo que irá ficar a mostra, Hide o tempo que levará para desaparecer
        title: "Titulo Padrão",
        //  trigger: 'click' //só irá aparecer o tooltip quando clickar no 
    } );
    $(".ppo").popover({
        title: "Titulo do PopOver",
        trigger: 'hover focus'
    });

    $("#btnjs").button();//Troca a pequena a caixa de marcação pela marção total do button
    
    $("#troca-estado").click(function(){
        var btn= $(this);
        btn.button("loading");//Ao clicar no botão ele fica no estado de carregando
        
        setTimeout(function(){
            btn.button("reset"); // depois de três segundos, volta ao normal
        }, 3000);
    });

    $('body').scrollspy({ target: '#navbaracademia' });
});
   