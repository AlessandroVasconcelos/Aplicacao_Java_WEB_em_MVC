function closeDialogIfSucess(xhr, status, args, dialogWidget, dialogId) {
        var jqDialog = jQuery('#' + dialog);
	if (args.validationFailed || args.KEEP_DIALOG_OPENED) {
//		jQuery('#'+dialogId).effect("bounce", {times : 4, distance : 20}, 100);

	} else {
		PF(dialogWidget).hide();
	}
}