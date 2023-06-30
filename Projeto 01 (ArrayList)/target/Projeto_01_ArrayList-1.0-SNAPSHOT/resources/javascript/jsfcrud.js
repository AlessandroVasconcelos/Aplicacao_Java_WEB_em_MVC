function handleSubmit(args, dialog) {
    var jqDialog = jQuery('#' + dialog);
    if (args.validationFailed) {
        jqDialog.effect('bounce', {times: 3}, 100);
    } else {
        PF(dialog).hide();
    }
}
