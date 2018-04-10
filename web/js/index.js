var init = function () {
    const $ = document.querySelector.bind(document);
    var usuario = $('input[name=userName]');
    var senha = $('input[name=userPass]');

    var modificarTexto = (campo) => {        
        if(campo.type !== 'text'){
            console.log('Só aceitamos campos de texto');
        }
        else if (campo.value === 'Digite o nome do usuário' || campo.value === 'Digite a sua senha') {
            campo.value = '';
            campo.style.color = "black";
            if (campo === senha) {
                senha.type = 'password';
            }
        }
    };
    
    var colocarTextoPadrao = (campo) => {
        if(campo.value === ''){
            campo.style.color = "gray";
            if(campo === usuario){
                campo.value = 'Digite o nome do usuário';
            }else if(campo === senha){
                campo.type = 'text';
                campo.value = 'Digite a sua senha';
            }
        }
    };

    usuario.addEventListener('click', () => modificarTexto(usuario));
    senha.addEventListener('click', () => modificarTexto(senha));
    usuario.addEventListener('focusin', () => modificarTexto(usuario));
    senha.addEventListener('focusin', () => modificarTexto(senha));
    usuario.addEventListener('focusout',() => colocarTextoPadrao(usuario));
    senha.addEventListener('focusout',() => colocarTextoPadrao(senha));

}();


