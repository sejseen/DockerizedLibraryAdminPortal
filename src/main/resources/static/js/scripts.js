$(document).ready(function () {
    $('.delete-book').on('click', function () {

        /*<![CDATA[*/
        var path =/*[[@{/}]]*/'deleteBook';
        /*]]>*/
        var id=$(this).attr('id');

        bootbox.confirm({
            message: "Czy na pewno chcesz usunąć tą pozycję z portalu?",
            buttons: {
                cancel: {
                    label:'<i class="fa fa-times"></i> Powrót'
                },
                confirm: {
                    label:'<i class="fa fa-times"></i> Potwierdź'
                }
            },
            callback: function (confirmed) {
                if(confirmed) {
                    $.post(path, {'id':id}, function (res) {
                        location.reload();
                    });
                }
            }
        });
    });
})
