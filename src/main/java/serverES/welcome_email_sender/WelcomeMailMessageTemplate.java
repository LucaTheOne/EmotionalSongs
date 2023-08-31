/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.welcome_email_sender;

/**
 * Classe con un unico metodo ritornante il template da compilare ed inviare tramite mail al nuovo utente.
 */
class WelcomeMailMessageTemplate {
    /**
     * @return template da compilare ed inviare tramite mail al nuovo utente.
     */
    protected String getMailWelcomeTemplate(){
        return """
               <!DOCTYPE html>
               
               <html lang="en" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:v="urn:schemas-microsoft-com:vml">
               <head>
               <title></title>
               <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
               <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
               <!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->
               <!--[if !mso]><!-->
               <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Merriweather" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Nunito" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Bitter" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Cabin" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Oxygen" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Droid+Serif" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet" type="text/css"/>
               <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" type="text/css"/>
               <!--<![endif]-->
               <style>
               		* {
               			box-sizing: border-box;
               		}
               
               		body {
               			margin: 0;
               			padding: 0;
               		}
               
               		a[x-apple-data-detectors] {
               			color: inherit !important;
               			text-decoration: inherit !important;
               		}
               
               		#MessageViewBody a {
               			color: inherit;
               			text-decoration: none;
               		}
               
               		p {
               			line-height: inherit
               		}
               
               		.desktop_hide,
               		.desktop_hide table {
               			mso-hide: all;
               			display: none;
               			max-height: 0px;
               			overflow: hidden;
               		}
               
               		@media (max-width:700px) {
               			.desktop_hide table.icons-inner {
               				display: inline-block !important;
               			}
               
               			.icons-inner {
               				text-align: center;
               			}
               
               			.icons-inner td {
               				margin: 0 auto;
               			}
               
               			.row-content {
               				width: 100% !important;
               			}
               
               			.mobile_hide {
               				display: none;
               			}
               
               			.stack .column {
               				width: 100%;
               				display: block;
               			}
               
               			.mobile_hide {
               				min-height: 0;
               				max-height: 0;
               				max-width: 0;
               				overflow: hidden;
               				font-size: 0px;
               			}
               
               			.desktop_hide,
               			.desktop_hide table {
               				display: table !important;
               				max-height: none !important;
               			}
               
               			.row-9 .column-1 .block-4.paragraph_block td.pad>div {
               				text-align: center !important;
               				font-size: 10px !important;
               			}
               		}
               	</style>
               </head>
               <body style="background-color: #f5f5f5; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;">
               <table border="0" cellpadding="0" cellspacing="0" class="nl-container" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f5f5f5;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row row-1" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row-content stack" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; border-radius: 0; width: 680px;" width="680">
               <tbody>
               <tr>
               <td class="column column-1" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="100%">
               <table border="0" cellpadding="0" cellspacing="0" class="heading_block block-2" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tr>
               <td class="pad" style="text-align:center;width:100%;padding-top:40px;padding-bottom:40px;">
               <h1 style="margin: 0; color: #000000; direction: ltr; font-family: Poppins, Arial, Helvetica, sans-serif; font-size: 38px; font-weight: 700; letter-spacing: normal; line-height: 150%; text-align: center; margin-top: 0; margin-bottom: 0;"><span class="tinyMce-placeholder">Emotional Songs</span></h1>
               </td>
               </tr>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row row-2" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row-content stack" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #0452ee; background-image: url('images/heasder-bg.png'); background-repeat: no-repeat; background-size: cover; color: #000000; width: 680px;" width="680">
               <tbody>
               <tr>
               <td class="column column-1" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="100%">
               <table border="0" cellpadding="0" cellspacing="0" class="heading_block block-1" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tr>
               <td class="pad" style="padding-bottom:30px;padding-top:30px;text-align:center;width:100%;">
               <h1 style="margin: 0; color: #ffffff; direction: ltr; font-family: Poppins, Arial, Helvetica, sans-serif; font-size: 38px; font-weight: 700; letter-spacing: normal; line-height: 150%; text-align: center; margin-top: 0; margin-bottom: 0;"><span class="tinyMce-placeholder">Grazie per la registrazione!</span></h1>
               </td>
               </tr>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row row-3" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row-content stack" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;" width="680">
               <tbody>
               <tr>
               <td class="column column-1" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-left: 50px; padding-right: 50px; vertical-align: top; padding-top: 0px; padding-bottom: 40px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="100%">
               <table border="0" cellpadding="20" cellspacing="0" class="divider_block block-1" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tr>
               <td class="pad">
               <div align="center" class="alignment">
               <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="15%">
               <tr>
               <td class="divider_inner" style="font-size: 1px; line-height: 1px; border-top: 3px solid #0452EE;"><span> </span></td>
               </tr>
               </table>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="text_block block-2" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad" style="padding-bottom:15px;padding-left:15px;padding-right:15px;padding-top:10px;">
               <div style="font-family: sans-serif">
               <div class="" style="font-size: 12px; mso-line-height-alt: 18px; color: #020b22; line-height: 1.5; font-family: Poppins, Arial, Helvetica, sans-serif;">
               <p style="margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 30px;"><span class="tinyMce-placeholder" style="font-size:20px;">Qui sotto troverai un riepilogo dei dati che ci hai fornito.<br/></span></p>
               </div>
               </div>
               </td>
               </tr>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row row-4" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row-content stack" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; border-radius: 0; color: #000000; width: 680px;" width="680">
               <tbody>
               <tr>
               <td class="column column-1" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="25%">
               <div class="spacer_block" style="height:30px;line-height:5px;font-size:1px;"> </div>
               </td>
               <td class="column column-2" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="50%">
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-2" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad" style="padding-top:5px;">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:700;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">Nome</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-3" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">%&0</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-4" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:700;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">Cognome</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-5" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">%&1</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-6" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:700;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">Data di nascita</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-7" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">%&2</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-8" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:700;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">Codice fiscale</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-9" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">%&3</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-10" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:700;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">Indirizzo</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-11" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">%&4</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-12" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:700;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">E-mail</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-13" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad" style="padding-bottom:5px;">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">%&5</p>
               </div>
               </td>
               </tr>
               </table>
               </td>
               <td class="column column-3" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="25%">
               <div class="spacer_block" style="height:30px;line-height:5px;font-size:1px;"> </div>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row row-5" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row-content stack" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; border-radius: 0; color: #000000; width: 680px;" width="680">
               <tbody>
               <tr>
               <td class="column column-1" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="100%">
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-2" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad" style="padding-top:30px;">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">Queste sono le tue credenziali di accesso, scelte in fase di registrazione.</p>
               </div>
               </td>
               </tr>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row row-6" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row-content stack" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #efefef; border-radius: 0; color: #000000; width: 680px;" width="680">
               <tbody>
               <tr>
               <td class="column column-1" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="25%">
               <div class="spacer_block" style="height:30px;line-height:5px;font-size:1px;"> </div>
               </td>
               <td class="column column-2" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="50%">
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-2" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad" style="padding-top:5px;">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:700;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;"><strong>User ID:</strong></p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-3" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:200%;text-align:center;mso-line-height-alt:32px;">
               <p style="margin: 0;">%&6</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-4" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:700;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;"><strong>Password:</strong></p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-5" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad" style="padding-bottom:5px;">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">%&7</p>
               </div>
               </td>
               </tr>
               </table>
               </td>
               <td class="column column-3" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="25%">
               <div class="spacer_block" style="height:30px;line-height:5px;font-size:1px;"> </div>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row row-7" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row-content stack" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;" width="680">
               <tbody>
               <tr>
               <td class="column column-1" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="100%">
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-2" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad" style="padding-top:20px;">
               <div style="color:#101112;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:28.8px;">
               <p style="margin: 0;">Le credenziali sono strettamente personali: mi raccomando, non condividerle con nessuno!</p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="divider_block block-4" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tr>
               <td class="pad" style="padding-bottom:20px;padding-left:20px;padding-right:20px;padding-top:40px;">
               <div align="center" class="alignment">
               <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="15%">
               <tr>
               <td class="divider_inner" style="font-size: 1px; line-height: 1px; border-top: 3px solid #0452EE;"><span> </span></td>
               </tr>
               </table>
               </div>
               </td>
               </tr>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row row-8" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row-content stack" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; border-radius: 0; color: #000000; width: 680px;" width="680">
               <tbody>
               <tr>
               <td class="column column-1" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="100%">
               <table border="0" cellpadding="0" cellspacing="0" class="heading_block block-1" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tr>
               <td class="pad" style="padding-bottom:10px;padding-top:15px;text-align:center;width:100%;">
               <h3 style="margin: 0; color: #0452ee; direction: ltr; font-family: Poppins, Arial, Helvetica, sans-serif; font-size: 24px; font-weight: 400; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;"><strong><span class="tinyMce-placeholder">Hai domande?</span></strong></h3>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="button_block block-2" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tr>
               <td class="pad" style="text-align:center;padding-bottom:20px;">
               <div align="center" class="alignment">
               <!--[if mso]><v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="mailto:emotionalsongs@ik.me?subject=Informazioni%20su%20Emotional%20Songs&body=Ciao%21%20Avrei%20una%20domanda%20su%20Emotional%20Songs..." style="height:42px;width:116px;v-text-anchor:middle;" arcsize="72%" strokeweight="1.5pt" strokecolor="#0452EE" fill="false"><w:anchorlock/><v:textbox inset="0px,0px,0px,0px"><center style="color:#2d2d2d; font-family:Arial, sans-serif; font-size:14px"><![endif]--><a href="mailto:emotionalsongs@ik.me?subject=Informazioni%20su%20Emotional%20Songs&body=Ciao%21%20Avrei%20una%20domanda%20su%20Emotional%20Songs..." style="text-decoration:none;display:inline-block;color:#2d2d2d;background-color:transparent;border-radius:30px;width:auto;border-top:2px solid #0452EE;font-weight:400;border-right:2px solid #0452EE;border-bottom:2px solid #0452EE;border-left:2px solid #0452EE;padding-top:5px;padding-bottom:5px;font-family:Poppins, Arial, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;" target="_blank"><span style="padding-left:30px;padding-right:30px;font-size:14px;display:inline-block;letter-spacing:normal;"><span dir="ltr" style="word-break: break-word;"><span class="tinyMce-placeholder" data-mce-style="" dir="ltr" style="line-height: 28px;">Scrivici</span></span></span></a>
               <!--[if mso]></center></v:textbox></v:roundrect><![endif]-->
               </div>
               </td>
               </tr>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row row-9" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row-content stack" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #0452ee; color: #000000; width: 680px;" width="680">
               <tbody>
               <tr>
               <td class="column column-1" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 25px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="100%">
               <table border="0" cellpadding="0" cellspacing="0" class="heading_block block-1" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tr>
               <td class="pad" style="padding-bottom:25px;padding-top:15px;text-align:center;width:100%;">
               <h3 style="margin: 0; color: #ffffff; direction: ltr; font-family: Poppins, Arial, Helvetica, sans-serif; font-size: 24px; font-weight: 400; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;"><strong><span class="tinyMce-placeholder">Non dimenticare di seguirci!</span></strong></h3>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-2" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#ffffff;font-size:16px;font-family:Poppins, Arial, Helvetica, sans-serif;font-weight:400;line-height:180%;text-align:center;direction:ltr;letter-spacing:0px;mso-line-height-alt:28.8px;">
               <p style="margin: 0;"><a href="https://twitter.com/emosongslab" rel="noopener" style="text-decoration: underline; color: #ffffff;" target="_blank">Twitter</a> | <a href="https://t.me/emotionalsongslab" rel="noopener" style="text-decoration: underline; color: #ffffff;" target="_blank">Telegram</a> | <a href="https://github.com/LucaTheOne/EmotionalSongs" rel="noopener" style="text-decoration: underline; color: #ffffff;" target="_blank">GitHub</a></p>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="20" cellspacing="0" class="text_block block-3" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="font-family: sans-serif">
               <div class="" style="font-size: 12px; font-family: Poppins, Arial, Helvetica, sans-serif; mso-line-height-alt: 18px; color: #fafafa; line-height: 1.5;">
               <p style="margin: 0; font-size: 10px; text-align: center; mso-line-height-alt: 15px;"><span style="font-size:10px;"><span style="">© 2022 Emotional Songs. </span></span><span style="font-size:10px;"><span style=""> All Rights Reserved.</span></span></p>
               </div>
               </div>
               </td>
               </tr>
               </table>
               <table border="0" cellpadding="0" cellspacing="0" class="paragraph_block block-4" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;" width="100%">
               <tr>
               <td class="pad">
               <div style="color:#efefef;direction:ltr;font-family:Poppins, Arial, Helvetica, sans-serif;font-size:12px;font-weight:400;letter-spacing:0px;line-height:180%;text-align:center;mso-line-height-alt:21.6px;">
               <p style="margin: 0;">Se non visualizzi correttamente la mail, fai clic qui.</p>
               </div>
               </td>
               </tr>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row row-10" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tbody>
               <tr>
               <td>
               <table align="center" border="0" cellpadding="0" cellspacing="0" class="row-content stack" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;" width="680">
               <tbody>
               <tr>
               <td class="column column-1" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;" width="100%">
               <table border="0" cellpadding="0" cellspacing="0" class="icons_block block-1" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tr>
               <td class="pad" style="vertical-align: middle; color: #9d9d9d; font-family: inherit; font-size: 15px; padding-bottom: 5px; padding-top: 5px; text-align: center;">
               <table cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;" width="100%">
               <tr>
               <td class="alignment" style="vertical-align: middle; text-align: center;">
               <!--[if vml]><table align="left" cellpadding="0" cellspacing="0" role="presentation" style="display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;"><![endif]-->
               <!--[if !vml]><!-->
               <table cellpadding="0" cellspacing="0" class="icons-inner" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;">
               <!--<![endif]-->
               <tr>
               <td style="vertical-align: middle; text-align: center; padding-top: 5px; padding-bottom: 5px; padding-left: 5px; padding-right: 6px;"><a href="https://www.designedwithbee.com/" style="text-decoration: none;" target="_blank"><img align="center" alt="Designed with BEE" class="icon" height="32" src="images/bee.png" style="display: block; height: auto; margin: 0 auto; border: 0;" width="34"/></a></td>
               <td style="font-family: Poppins, Arial, Helvetica, sans-serif; font-size: 15px; color: #9d9d9d; vertical-align: middle; letter-spacing: undefined; text-align: center;"><a href="https://www.designedwithbee.com/" style="color: #9d9d9d; text-decoration: none;" target="_blank">Designed with BEE</a></td>
               </tr>
               </table>
               </td>
               </tr>
               </table>
               </td>
               </tr>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table>
               </td>
               </tr>
               </tbody>
               </table><!-- End -->
               </body>
               </html>
               """;
    }
}
