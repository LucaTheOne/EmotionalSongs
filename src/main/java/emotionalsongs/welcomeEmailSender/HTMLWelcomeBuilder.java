package emotionalsongs.welcomeEmailSender;


import emotionalsongs.BasicsStructure.*;
import emotionalsongs.*;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author big
 */
class HTMLWelcomeBuilder {
    
    User user = EMOTIONALSONGS.userDataBase.getUser(5);
    
    public HTMLWelcomeBuilder() {                
    }
    
    
    
     String html = "<!DOCTYPE html>\n" +
"\n" +
"<html lang=\"en\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
"<head>\n" +
"<title></title>\n" +
"<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
"<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\n" +
"<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
"<!--[if !mso]><!-->\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Abril+Fatface\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Merriweather\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Nunito\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Bitter\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Permanent+Marker\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Roboto+Slab\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Cabin\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Oxygen\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Oswald\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Ubuntu\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Open+Sans\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Droid+Serif\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Playfair+Display\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Poppins\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<!--<![endif]-->\n" +
"<style>\n" +
"		* {\n" +
"			box-sizing: border-box;\n" +
"		}\n" +
"\n" +
"		body {\n" +
"			margin: 0;\n" +
"			padding: 0;\n" +
"		}\n" +
"\n" +
"		a[x-apple-data-detectors] {\n" +
"			color: inherit !important;\n" +
"			text-decoration: inherit !important;\n" +
"		}\n" +
"\n" +
"		#MessageViewBody a {\n" +
"			color: inherit;\n" +
"			text-decoration: none;\n" +
"		}\n" +
"\n" +
"		p {\n" +
"			line-height: inherit\n" +
"		}\n" +
"\n" +
"		.desktop_hide,\n" +
"		.desktop_hide table {\n" +
"			mso-hide: all;\n" +
"			display: none;\n" +
"			max-height: 0px;\n" +
"			overflow: hidden;\n" +
"		}\n" +
"\n" +
"		@media (max-width:700px) {\n" +
"\n" +
"			.desktop_hide table.icons-inner,\n" +
"			.social_block.desktop_hide .social-table {\n" +
"				display: inline-block !important;\n" +
"			}\n" +
"\n" +
"			.icons-inner {\n" +
"				text-align: center;\n" +
"			}\n" +
"\n" +
"			.icons-inner td {\n" +
"				margin: 0 auto;\n" +
"			}\n" +
"\n" +
"			.fullMobileWidth,\n" +
"			.image_block img.big,\n" +
"			.row-content {\n" +
"				width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.mobile_hide {\n" +
"				display: none;\n" +
"			}\n" +
"\n" +
"			.stack .column {\n" +
"				width: 100%;\n" +
"				display: block;\n" +
"			}\n" +
"\n" +
"			.mobile_hide {\n" +
"				min-height: 0;\n" +
"				max-height: 0;\n" +
"				max-width: 0;\n" +
"				overflow: hidden;\n" +
"				font-size: 0px;\n" +
"			}\n" +
"\n" +
"			.desktop_hide,\n" +
"			.desktop_hide table {\n" +
"				display: table !important;\n" +
"				max-height: none !important;\n" +
"			}\n" +
"\n" +
"			.reverse {\n" +
"				display: table;\n" +
"				width: 100%;\n" +
"			}\n" +
"\n" +
"			.reverse .column.first {\n" +
"				display: table-footer-group !important;\n" +
"			}\n" +
"\n" +
"			.reverse .column.last {\n" +
"				display: table-header-group !important;\n" +
"			}\n" +
"\n" +
"			.row-9 td.column.first>table,\n" +
"			.row-9 td.column.last>table {\n" +
"				padding-left: 30px;\n" +
"				padding-right: 30px;\n" +
"			}\n" +
"\n" +
"			.row-9 td.column.first .border,\n" +
"			.row-9 td.column.last .border {\n" +
"				border-top: 0;\n" +
"				border-right: 0px;\n" +
"				border-bottom: 0;\n" +
"				border-left: 0;\n" +
"			}\n" +
"		}\n" +
"	</style>\n" +
"</head>\n" +
"<body style=\"background-color: #f5f5f5; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f5f5f5;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"66.66666666666667%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"text-align:center;width:100%;padding-top:20px;padding-bottom:20px;\">\n" +
"<h1 style=\"margin: 0; color: #000000; direction: ltr; font-family: Poppins, Arial, Helvetica, sans-serif; font-size: 38px; font-weight: 700; letter-spacing: normal; line-height: 150%; text-align: center; margin-top: 0; margin-bottom: 0;\"><span class=\"tinyMce-placeholder\">Emotional Songs</span></h1>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"33.333333333333336%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:5px;padding-bottom:5px;\">\n" +
"<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img src=\"https://github.com/LucaTheOne/EmotionalSongs/blob/main/Risorse/email-registration-confirm-def/images/EmotionalSongsLogo.png\" style=\"display: block; height: auto; border: 0; width: 102px; max-width: 100%;\" width=\"102\"/></div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #0452ee; background-image: url('images/heasder-bg.png'); background-repeat: no-repeat; background-size: cover; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-bottom:30px;padding-top:30px;text-align:center;width:100%;\">\n" +
"<h1 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Poppins, Arial, Helvetica, sans-serif; font-size: 38px; font-weight: 700; letter-spacing: normal; line-height: 150%; text-align: center; margin-top: 0; margin-bottom: 0;\"><span class=\"tinyMce-placeholder\">Grazie per la registrazione!</span></h1>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
"<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Contacts\" class=\"fullMobileWidth\" src=\"https://github.com/LucaTheOne/EmotionalSongs/blob/main/Risorse/email-registration-confirm-def/images/contacts_no-bg.gif\" style=\"display: block; height: auto; border: 0; width: 340px; max-width: 100%;\" title=\"Contacts\" width=\"340\"/></div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-left: 50px; padding-right: 50px; vertical-align: top; padding-top: 0px; padding-bottom: 40px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
"<table border=\"0\" cellpadding=\"20\" cellspacing=\"0\" class=\"divider_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div align=\"center\" class=\"alignment\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"15%\">\n" +
"<tr>\n" +
"<td class=\"divider_inner\" style=\"font-size: 1px; line-height: 1px; border-top: 3px solid #0452EE;\"><span> </span></td>\n" +
"</tr>\n" +
"</table>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-bottom:15px;padding-left:15px;padding-right:15px;padding-top:10px;\">\n" +
"<div style=\"font-family: sans-serif\">\n" +
"<div class=\"\" style=\"font-size: 12px; mso-line-height-alt: 18px; color: #020b22; line-height: 1.5; font-family: Poppins, Arial, Helvetica, sans-serif;\">\n" +
"<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 30px;\"><span class=\"tinyMce-placeholder\" style=\"font-size:20px;\">Qui sotto troverai un riepilogo dei dati che ci hai fornito.<br/></span></p>\n" +
"</div>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; border-radius: 0; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"25%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-top:5px;\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:right;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\"><strong>Nome:</strong></p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:right;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\"><strong>Cognome:</strong></p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:right;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\"><strong>E-mail:</strong></p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-5\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:right;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\"><strong>Indirizzo:</strong></p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-6\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-bottom:5px;\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:right;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\"><strong>Codice fiscale:</strong></p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"75%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-top:5px;\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\">"+ user.getNome() +"</p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\">"+ user.getCognome() +"</p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\">"+ user.getEmail() +"</p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-5\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\">"+ user.getIndirizzo() +"</p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-6\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-bottom:5px;\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\">"+ user.getCF() +"</p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-6\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; border-radius: 0; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\">Queste sono le tue credenziali di accesso, scelte in fase di registrazione.</p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-7\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #efefef; border-radius: 0; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"25%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"empty_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-right:0px;padding-bottom:5px;padding-left:0px;padding-top:5px;\">\n" +
"<div></div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"50%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-top:5px;\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\"><strong>User ID:</strong></p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:200%;text-align:center;mso-line-height-alt:32px;\">\n" +
"<p style=\"margin: 0;\">"+ user.getUserId() +"</p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\"><strong>Password:</strong></p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-5\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-bottom:5px;\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\">"+ user.getPassword() +"</p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"25%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"empty_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-right:0px;padding-bottom:5px;padding-left:0px;padding-top:5px;\">\n" +
"<div></div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-8\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;\">\n" +
"<p style=\"margin: 0;\">Le credenziali sono strettamente personali: mi raccomando, non condividerle con nessuno!</p>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-bottom:20px;padding-left:20px;padding-right:20px;padding-top:40px;\">\n" +
"<div align=\"center\" class=\"alignment\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"15%\">\n" +
"<tr>\n" +
"<td class=\"divider_inner\" style=\"font-size: 1px; line-height: 1px; border-top: 3px solid #0452EE;\"><span> </span></td>\n" +
"</tr>\n" +
"</table>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
"<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img class=\"big\" src=\"https://github.com/LucaTheOne/EmotionalSongs/blob/main/Risorse/email-registration-confirm-def/images/footer-bg.png\" style=\"display: block; height: auto; border: 0; width: 680px; max-width: 100%;\" width=\"680\"/></div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-9\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fafafa; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr class=\"reverse\">\n" +
"<td class=\"column column-1 first\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-left: 30px; padding-right: 30px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"50%\">\n" +
"<div class=\"border\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-bottom:40px;padding-top:35px;text-align:center;width:100%;\">\n" +
"<h3 style=\"margin: 0; color: #0452ee; direction: ltr; font-family: Poppins, Arial, Helvetica, sans-serif; font-size: 24px; font-weight: 400; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><strong><span class=\"tinyMce-placeholder\">Hai domande?</span></strong></h3>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</div>\n" +
"</td>\n" +
"<td class=\"column column-2 last\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-left: 30px; padding-right: 30px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"50%\">\n" +
"<div class=\"border\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"text-align:center;padding-top:25px;padding-bottom:50px;\">\n" +
"<div align=\"center\" class=\"alignment\">\n" +
"<!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"https://emotionalsongs.tk\" style=\"height:42px;width:112px;v-text-anchor:middle;\" arcsize=\"72%\" strokeweight=\"1.5pt\" strokecolor=\"#0452EE\" fill=\"false\"><w:anchorlock/><v:textbox inset=\"0px,0px,0px,0px\"><center style=\"color:#2d2d2d; font-family:Arial, sans-serif; font-size:14px\"><![endif]--><a href=\"https://emotionalsongs.tk\" style=\"text-decoration:none;display:inline-block;color:#2d2d2d;background-color:transparent;border-radius:30px;width:auto;border-top:2px solid #0452EE;font-weight:400;border-right:2px solid #0452EE;border-bottom:2px solid #0452EE;border-left:2px solid #0452EE;padding-top:5px;padding-bottom:5px;font-family:Poppins, Arial, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\" target=\"_blank\"><span style=\"padding-left:30px;padding-right:30px;font-size:14px;display:inline-block;letter-spacing:normal;\"><span dir=\"ltr\" style=\"word-break: break-word;\"><span class=\"tinyMce-placeholder\" data-mce-style=\"\" dir=\"ltr\" style=\"line-height: 28px;\">Scrivici</span></span></span></a>\n" +
"<!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-10\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #0452ee; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 25px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"padding-bottom:25px;padding-top:15px;text-align:center;width:100%;\">\n" +
"<h3 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Poppins, Arial, Helvetica, sans-serif; font-size: 24px; font-weight: 400; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><strong><span class=\"tinyMce-placeholder\">Non dimenticare di seguirci!</span></strong></h3>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"social_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div class=\"alignment\" style=\"text-align:center;\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"social-table\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block;\" width=\"108px\">\n" +
"<tr>\n" +
"<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.twitter.com/emosongslab\" target=\"_blank\"><img alt=\"Twitter\" height=\"32\" src=\"https://github.com/LucaTheOne/EmotionalSongs/blob/main/Risorse/email-registration-confirm-def/images/twitter2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"Twitter\" width=\"32\"/></a></td>\n" +
"<td style=\"padding:0 2px 0 2px;\"><a href=\"https://t.me/emotionalsongslab\" target=\"_blank\"><img alt=\"Telegram\" height=\"32\" src=\"https://github.com/LucaTheOne/EmotionalSongs/blob/main/Risorse/email-registration-confirm-def/images/telegram2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"Telegram\" width=\"32\"/></a></td>\n" +
"<td style=\"padding:0 2px 0 2px;\"><a href=\"mailto:mailto:emotionalsongs@ik.me\" target=\"_blank\"><img alt=\"E-Mail\" height=\"32\" src=\"https://github.com/LucaTheOne/EmotionalSongs/blob/main/Risorse/email-registration-confirm-def/images/mail2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"E-Mail\" width=\"32\"/></a></td>\n" +
"</tr>\n" +
"</table>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<table border=\"0\" cellpadding=\"20\" cellspacing=\"0\" class=\"text_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\">\n" +
"<div style=\"font-family: sans-serif\">\n" +
"<div class=\"\" style=\"font-size: 12px; font-family: Poppins, Arial, Helvetica, sans-serif; mso-line-height-alt: 18px; color: #fafafa; line-height: 1.5;\">\n" +
"<p style=\"margin: 0; font-size: 10px; text-align: center; mso-line-height-alt: 15px;\"><span style=\"font-size:10px;\"><span style=\"\">© 2022 Company. </span></span><span style=\"font-size:10px;\"><span style=\"\"> All Rights Reserved.</span></span></p>\n" +
"</div>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-11\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
"<tbody>\n" +
"<tr>\n" +
"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"pad\" style=\"vertical-align: middle; color: #9d9d9d; font-family: inherit; font-size: 15px; padding-bottom: 5px; padding-top: 5px; text-align: center;\">\n" +
"<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
"<tr>\n" +
"<td class=\"alignment\" style=\"vertical-align: middle; text-align: center;\">\n" +
"<!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\n" +
"<!--[if !vml]><!-->\n" +
"<table cellpadding=\"0\" cellspacing=\"0\" class=\"icons-inner\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\">\n" +
"<!--<![endif]-->\n" +
"<tr>\n" +
"<td style=\"vertical-align: middle; text-align: center; padding-top: 5px; padding-bottom: 5px; padding-left: 5px; padding-right: 6px;\"><a href=\"https://www.designedwithbee.com/\" style=\"text-decoration: none;\" target=\"_blank\"><img align=\"center\" alt=\"Designed with BEE\" class=\"icon\" height=\"32\" src=\"https://github.com/LucaTheOne/EmotionalSongs/blob/main//Risorse/email-registration-confirm-def/images/bee.png\" style=\"display: block; height: auto; margin: 0 auto; border: 0;\" width=\"34\"/></a></td>\n" +
"<td style=\"font-family: Poppins, Arial, Helvetica, sans-serif; font-size: 15px; color: #9d9d9d; vertical-align: middle; letter-spacing: undefined; text-align: center;\"><a href=\"https://www.designedwithbee.com/\" style=\"color: #9d9d9d; text-decoration: none;\" target=\"_blank\">Designed with BEE</a></td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table><!-- End -->\n" +
"</body>\n" +
"</html>";   
}
