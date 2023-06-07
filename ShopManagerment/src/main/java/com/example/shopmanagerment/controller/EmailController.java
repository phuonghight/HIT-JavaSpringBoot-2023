package com.example.shopmanagerment.controller;

import com.example.shopmanagerment.email.EmailService;
import com.example.shopmanagerment.model.User;
import com.example.shopmanagerment.service.UserService;
import com.example.shopmanagerment.utils.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.List;


@EnableScheduling
@ConditionalOnExpression("true")
@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @Scheduled(cron = "0 0 0 * * *")
    public void sendBirthdayEmail() throws MessagingException {
        List<User> users = userService.getAllUser();
        for (User u : users) {
            if (Check.isBornToday(u.getBirthday())) {
                String email = u.getEmail();
                String subject = "Happy Birthday!!!";

                String content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                        "\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                        "    <meta name=\"x-apple-disable-message-reformatting\">\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "    <meta content=\"telephone=no\" name=\"format-detection\">\n" +
                        "    <title></title>\n" +
                        "    <!--[if (mso 16)]>\n" +
                        "    <style type=\"text/css\">\n" +
                        "    a {text-decoration: none;}\n" +
                        "    </style>\n" +
                        "    <![endif]-->\n" +
                        "    <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\n" +
                        "    <!--[if gte mso 9]>\n" +
                        "<xml>\n" +
                        "    <o:OfficeDocumentSettings>\n" +
                        "    <o:AllowPNG></o:AllowPNG>\n" +
                        "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                        "    </o:OfficeDocumentSettings>\n" +
                        "</xml>\n" +
                        "<![endif]-->\n" +
                        "    <style>\n" +
                        "        /* CONFIG STYLES Please do not delete and edit CSS styles below */\n" +
                        "        /* IMPORTANT THIS STYLES MUST BE ON FINAL EMAIL */\n" +
                        "        #outlook a {\n" +
                        "            padding: 0;\n" +
                        "        }\n" +
                        "\n" +
                        "        .ExternalClass {\n" +
                        "            width: 100%;\n" +
                        "        }\n" +
                        "\n" +
                        "        .ExternalClass,\n" +
                        "        .ExternalClass p,\n" +
                        "        .ExternalClass span,\n" +
                        "        .ExternalClass font,\n" +
                        "        .ExternalClass td,\n" +
                        "        .ExternalClass div {\n" +
                        "            line-height: 100%;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-button {\n" +
                        "            mso-style-priority: 100 !important;\n" +
                        "            text-decoration: none !important;\n" +
                        "        }\n" +
                        "\n" +
                        "        a[x-apple-data-detectors] {\n" +
                        "            color: inherit !important;\n" +
                        "            text-decoration: none !important;\n" +
                        "            font-size: inherit !important;\n" +
                        "            font-family: inherit !important;\n" +
                        "            font-weight: inherit !important;\n" +
                        "            line-height: inherit !important;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-desk-hidden {\n" +
                        "            display: none;\n" +
                        "            float: left;\n" +
                        "            overflow: hidden;\n" +
                        "            width: 0;\n" +
                        "            max-height: 0;\n" +
                        "            line-height: 0;\n" +
                        "            mso-hide: all;\n" +
                        "        }\n" +
                        "\n" +
                        "        /*\n" +
                        "END OF IMPORTANT\n" +
                        "*/\n" +
                        "        s {\n" +
                        "            text-decoration: line-through;\n" +
                        "        }\n" +
                        "\n" +
                        "        html,\n" +
                        "        body {\n" +
                        "            width: 100%;\n" +
                        "            -webkit-text-size-adjust: 100%;\n" +
                        "            -ms-text-size-adjust: 100%;\n" +
                        "        }\n" +
                        "\n" +
                        "        body {\n" +
                        "            font-family: 'arial', 'helvetica neue', 'helvetica', 'sans-serif';\n" +
                        "        }\n" +
                        "\n" +
                        "        table {\n" +
                        "            mso-table-lspace: 0pt;\n" +
                        "            mso-table-rspace: 0pt;\n" +
                        "            border-collapse: collapse;\n" +
                        "            border-spacing: 0px;\n" +
                        "        }\n" +
                        "\n" +
                        "        table td,\n" +
                        "        html,\n" +
                        "        body,\n" +
                        "        .es-wrapper {\n" +
                        "            padding: 0;\n" +
                        "            Margin: 0;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-content,\n" +
                        "        .es-header,\n" +
                        "        .es-footer {\n" +
                        "            table-layout: fixed !important;\n" +
                        "            width: 100%;\n" +
                        "        }\n" +
                        "\n" +
                        "        img {\n" +
                        "            display: block;\n" +
                        "            border: 0;\n" +
                        "            outline: none;\n" +
                        "            text-decoration: none;\n" +
                        "            -ms-interpolation-mode: bicubic;\n" +
                        "        }\n" +
                        "\n" +
                        "        table tr {\n" +
                        "            border-collapse: collapse;\n" +
                        "        }\n" +
                        "\n" +
                        "        p,\n" +
                        "        hr {\n" +
                        "            Margin: 0;\n" +
                        "        }\n" +
                        "\n" +
                        "        h1,\n" +
                        "        h2,\n" +
                        "        h3,\n" +
                        "        h4,\n" +
                        "        h5 {\n" +
                        "            Margin: 0;\n" +
                        "            line-height: 120%;\n" +
                        "            mso-line-height-rule: exactly;\n" +
                        "            font-family: 'arial', 'helvetica neue', 'helvetica', 'sans-serif';\n" +
                        "        }\n" +
                        "\n" +
                        "        p,\n" +
                        "        ul li,\n" +
                        "        ol li,\n" +
                        "        a {\n" +
                        "            -webkit-text-size-adjust: none;\n" +
                        "            -ms-text-size-adjust: none;\n" +
                        "            mso-line-height-rule: exactly;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-left {\n" +
                        "            float: left;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-right {\n" +
                        "            float: right;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p5 {\n" +
                        "            padding: 5px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p5t {\n" +
                        "            padding-top: 5px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p5b {\n" +
                        "            padding-bottom: 5px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p5l {\n" +
                        "            padding-left: 5px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p5r {\n" +
                        "            padding-right: 5px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p10 {\n" +
                        "            padding: 10px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p10t {\n" +
                        "            padding-top: 10px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p10b {\n" +
                        "            padding-bottom: 10px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p10l {\n" +
                        "            padding-left: 10px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p10r {\n" +
                        "            padding-right: 10px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p15 {\n" +
                        "            padding: 15px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p15t {\n" +
                        "            padding-top: 15px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p15b {\n" +
                        "            padding-bottom: 15px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p15l {\n" +
                        "            padding-left: 15px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p15r {\n" +
                        "            padding-right: 15px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p20 {\n" +
                        "            padding: 20px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p20t {\n" +
                        "            padding-top: 20px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p20b {\n" +
                        "            padding-bottom: 20px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p20l {\n" +
                        "            padding-left: 20px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p20r {\n" +
                        "            padding-right: 20px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p25 {\n" +
                        "            padding: 25px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p25t {\n" +
                        "            padding-top: 25px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p25b {\n" +
                        "            padding-bottom: 25px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p25l {\n" +
                        "            padding-left: 25px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p25r {\n" +
                        "            padding-right: 25px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p30 {\n" +
                        "            padding: 30px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p30t {\n" +
                        "            padding-top: 30px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p30b {\n" +
                        "            padding-bottom: 30px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p30l {\n" +
                        "            padding-left: 30px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p30r {\n" +
                        "            padding-right: 30px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p35 {\n" +
                        "            padding: 35px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p35t {\n" +
                        "            padding-top: 35px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p35b {\n" +
                        "            padding-bottom: 35px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p35l {\n" +
                        "            padding-left: 35px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p35r {\n" +
                        "            padding-right: 35px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p40 {\n" +
                        "            padding: 40px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p40t {\n" +
                        "            padding-top: 40px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p40b {\n" +
                        "            padding-bottom: 40px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p40l {\n" +
                        "            padding-left: 40px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-p40r {\n" +
                        "            padding-right: 40px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-menu td {\n" +
                        "            border: 0;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-menu td a {\n" +
                        "            text-decoration: none;\n" +
                        "            display: block;\n" +
                        "            font-family: 'arial', 'helvetica neue', 'helvetica', 'sans-serif';\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-menu td a img {\n" +
                        "            display: inline-block !important;\n" +
                        "        }\n" +
                        "\n" +
                        "        /* END CONFIG STYLES */\n" +
                        "        a {\n" +
                        "            text-decoration: underline;\n" +
                        "        }\n" +
                        "\n" +
                        "        p,\n" +
                        "        ul li,\n" +
                        "        ol li {\n" +
                        "            font-family: 'arial', 'helvetica neue', 'helvetica', 'sans-serif';\n" +
                        "            line-height: 150%;\n" +
                        "        }\n" +
                        "\n" +
                        "        ul li,\n" +
                        "        ol li {\n" +
                        "            Margin-bottom: 15px;\n" +
                        "            margin-left: 0;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-wrapper {\n" +
                        "            width: 100%;\n" +
                        "            height: 100%;\n" +
                        "            background-repeat: repeat;\n" +
                        "            background-position: center top;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-wrapper-color,\n" +
                        "        .es-wrapper {\n" +
                        "            background-color: #efefef;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-header {\n" +
                        "            background-color: transparent;\n" +
                        "            background-repeat: repeat;\n" +
                        "            background-position: center top;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-header-body {\n" +
                        "            background-color: #ffffff;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-header-body p,\n" +
                        "        .es-header-body ul li,\n" +
                        "        .es-header-body ol li {\n" +
                        "            color: #333333;\n" +
                        "            font-size: 14px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-header-body a {\n" +
                        "            color: #000000;\n" +
                        "            font-size: 14px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-content-body {\n" +
                        "            background-color: #ffffff;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-content-body p,\n" +
                        "        .es-content-body ul li,\n" +
                        "        .es-content-body ol li {\n" +
                        "            color: #333333;\n" +
                        "            font-size: 14px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-content-body a {\n" +
                        "            color: #000000;\n" +
                        "            font-size: 14px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-footer {\n" +
                        "            background-color: transparent;\n" +
                        "            background-repeat: repeat;\n" +
                        "            background-position: center top;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-footer-body {\n" +
                        "            background-color: transparent;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-footer-body p,\n" +
                        "        .es-footer-body ul li,\n" +
                        "        .es-footer-body ol li {\n" +
                        "            color: #333333;\n" +
                        "            font-size: 12px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-footer-body a {\n" +
                        "            color: #000000;\n" +
                        "            font-size: 12px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-infoblock,\n" +
                        "        .es-infoblock p,\n" +
                        "        .es-infoblock ul li,\n" +
                        "        .es-infoblock ol li {\n" +
                        "            line-height: 120%;\n" +
                        "            font-size: 12px;\n" +
                        "            color: #333333;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-infoblock a {\n" +
                        "            font-size: 12px;\n" +
                        "            color: #000000;\n" +
                        "        }\n" +
                        "\n" +
                        "        h1 {\n" +
                        "            font-size: 34px;\n" +
                        "            font-style: normal;\n" +
                        "            font-weight: bold;\n" +
                        "            color: #333333;\n" +
                        "        }\n" +
                        "\n" +
                        "        h2 {\n" +
                        "            font-size: 26px;\n" +
                        "            font-style: normal;\n" +
                        "            font-weight: bold;\n" +
                        "            color: #333333;\n" +
                        "        }\n" +
                        "\n" +
                        "        h3 {\n" +
                        "            font-size: 20px;\n" +
                        "            font-style: normal;\n" +
                        "            font-weight: normal;\n" +
                        "            color: #333333;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-header-body h1 a,\n" +
                        "        .es-content-body h1 a,\n" +
                        "        .es-footer-body h1 a {\n" +
                        "            font-size: 34px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-header-body h2 a,\n" +
                        "        .es-content-body h2 a,\n" +
                        "        .es-footer-body h2 a {\n" +
                        "            font-size: 26px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-header-body h3 a,\n" +
                        "        .es-content-body h3 a,\n" +
                        "        .es-footer-body h3 a {\n" +
                        "            font-size: 20px;\n" +
                        "        }\n" +
                        "\n" +
                        "        a.es-button,\n" +
                        "        button.es-button {\n" +
                        "            display: inline-block;\n" +
                        "            background: #ffffff;\n" +
                        "            border-radius: 0px;\n" +
                        "            font-size: 18px;\n" +
                        "            font-family: 'arial', 'helvetica neue', 'helvetica', 'sans-serif';\n" +
                        "            font-weight: bold;\n" +
                        "            font-style: normal;\n" +
                        "            line-height: 120%;\n" +
                        "            color: #9a7baa;\n" +
                        "            text-decoration: none;\n" +
                        "            width: auto;\n" +
                        "            text-align: center;\n" +
                        "            padding: 10px 20px 10px 20px;\n" +
                        "            mso-padding-alt: 0;\n" +
                        "            mso-border-alt: 10px solid #ffffff;\n" +
                        "        }\n" +
                        "\n" +
                        "        .es-button-border {\n" +
                        "            border-style: solid solid solid solid;\n" +
                        "            border-color: #ffffff #ffffff #ffffff #ffffff;\n" +
                        "            background: #2cb543;\n" +
                        "            border-width: 0px 0px 0px 0px;\n" +
                        "            display: inline-block;\n" +
                        "            border-radius: 0px;\n" +
                        "            width: auto;\n" +
                        "        }\n" +
                        "\n" +
                        "        /* RESPONSIVE STYLES Please do not delete and edit CSS styles below. If you don't need responsive layout, please delete this section. */\n" +
                        "        @media only screen and (max-width: 600px) {\n" +
                        "\n" +
                        "            p,\n" +
                        "            ul li,\n" +
                        "            ol li,\n" +
                        "            a {\n" +
                        "                line-height: 150% !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            h1,\n" +
                        "            h2,\n" +
                        "            h3,\n" +
                        "            h1 a,\n" +
                        "            h2 a,\n" +
                        "            h3 a {\n" +
                        "                line-height: 120% !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            h1 {\n" +
                        "                font-size: 30px !important;\n" +
                        "                text-align: center;\n" +
                        "            }\n" +
                        "\n" +
                        "            h2 {\n" +
                        "                font-size: 26px !important;\n" +
                        "                text-align: center;\n" +
                        "            }\n" +
                        "\n" +
                        "            h3 {\n" +
                        "                font-size: 20px !important;\n" +
                        "                text-align: center;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-header-body h1 a,\n" +
                        "            .es-content-body h1 a,\n" +
                        "            .es-footer-body h1 a {\n" +
                        "                font-size: 30px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-header-body h2 a,\n" +
                        "            .es-content-body h2 a,\n" +
                        "            .es-footer-body h2 a {\n" +
                        "                font-size: 26px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-header-body h3 a,\n" +
                        "            .es-content-body h3 a,\n" +
                        "            .es-footer-body h3 a {\n" +
                        "                font-size: 20px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-header-body p,\n" +
                        "            .es-header-body ul li,\n" +
                        "            .es-header-body ol li,\n" +
                        "            .es-header-body a {\n" +
                        "                font-size: 16px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-content-body p,\n" +
                        "            .es-content-body ul li,\n" +
                        "            .es-content-body ol li,\n" +
                        "            .es-content-body a {\n" +
                        "                font-size: 16px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-footer-body p,\n" +
                        "            .es-footer-body ul li,\n" +
                        "            .es-footer-body ol li,\n" +
                        "            .es-footer-body a {\n" +
                        "                font-size: 16px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-infoblock p,\n" +
                        "            .es-infoblock ul li,\n" +
                        "            .es-infoblock ol li,\n" +
                        "            .es-infoblock a {\n" +
                        "                font-size: 12px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            *[class=\"gmail-fix\"] {\n" +
                        "                display: none !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-m-txt-c,\n" +
                        "            .es-m-txt-c h1,\n" +
                        "            .es-m-txt-c h2,\n" +
                        "            .es-m-txt-c h3 {\n" +
                        "                text-align: center !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-m-txt-r,\n" +
                        "            .es-m-txt-r h1,\n" +
                        "            .es-m-txt-r h2,\n" +
                        "            .es-m-txt-r h3 {\n" +
                        "                text-align: right !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-m-txt-l,\n" +
                        "            .es-m-txt-l h1,\n" +
                        "            .es-m-txt-l h2,\n" +
                        "            .es-m-txt-l h3 {\n" +
                        "                text-align: left !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-m-txt-r img,\n" +
                        "            .es-m-txt-c img,\n" +
                        "            .es-m-txt-l img {\n" +
                        "                display: inline !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-button-border {\n" +
                        "                display: block !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            a.es-button,\n" +
                        "            button.es-button {\n" +
                        "                font-size: 20px !important;\n" +
                        "                display: block !important;\n" +
                        "                padding: 10px 0px 10px 0px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-btn-fw {\n" +
                        "                border-width: 10px 0px !important;\n" +
                        "                text-align: center !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-adaptive table,\n" +
                        "            .es-btn-fw,\n" +
                        "            .es-btn-fw-brdr,\n" +
                        "            .es-left,\n" +
                        "            .es-right {\n" +
                        "                width: 100% !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-content table,\n" +
                        "            .es-header table,\n" +
                        "            .es-footer table,\n" +
                        "            .es-content,\n" +
                        "            .es-footer,\n" +
                        "            .es-header {\n" +
                        "                width: 100% !important;\n" +
                        "                max-width: 600px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-adapt-td {\n" +
                        "                display: block !important;\n" +
                        "                width: 100% !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .adapt-img {\n" +
                        "                width: 100% !important;\n" +
                        "                height: auto !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-m-p0 {\n" +
                        "                padding: 0px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-m-p0r {\n" +
                        "                padding-right: 0px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-m-p0l {\n" +
                        "                padding-left: 0px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-m-p0t {\n" +
                        "                padding-top: 0px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-m-p0b {\n" +
                        "                padding-bottom: 0 !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-m-p20b {\n" +
                        "                padding-bottom: 20px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-mobile-hidden,\n" +
                        "            .es-hidden {\n" +
                        "                display: none !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            tr.es-desk-hidden,\n" +
                        "            td.es-desk-hidden,\n" +
                        "            table.es-desk-hidden {\n" +
                        "                width: auto !important;\n" +
                        "                overflow: visible !important;\n" +
                        "                float: none !important;\n" +
                        "                max-height: inherit !important;\n" +
                        "                line-height: inherit !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            tr.es-desk-hidden {\n" +
                        "                display: table-row !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            table.es-desk-hidden {\n" +
                        "                display: table !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            td.es-desk-menu-hidden {\n" +
                        "                display: table-cell !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-menu td {\n" +
                        "                width: 1% !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            table.es-table-not-adapt,\n" +
                        "            .esd-block-html table {\n" +
                        "                width: auto !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            table.es-social {\n" +
                        "                display: inline-block !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            table.es-social td {\n" +
                        "                display: inline-block !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-menu td a {\n" +
                        "                font-size: 14px !important;\n" +
                        "            }\n" +
                        "\n" +
                        "            .es-desk-hidden {\n" +
                        "                display: table-row !important;\n" +
                        "                width: auto !important;\n" +
                        "                overflow: visible !important;\n" +
                        "                max-height: inherit !important;\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        /* END RESPONSIVE STYLES */\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "\n" +
                        "<body data-new-gr-c-s-loaded=\"14.1030.0\">\n" +
                        "    <div class=\"es-wrapper-color\">\n" +
                        "        <!--[if gte mso 9]>\n" +
                        "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                        "\t\t\t\t<v:fill type=\"tile\" color=\"#efefef\"></v:fill>\n" +
                        "\t\t\t</v:background>\n" +
                        "\t\t<![endif]-->\n" +
                        "        <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                        "            <tbody>\n" +
                        "                <tr>\n" +
                        "                    <td class=\"esd-email-paddings\" valign=\"top\">\n" +
                        "                        <table class=\"es-content esd-footer-popover\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                        "                            <tbody>\n" +
                        "                                <tr>\n" +
                        "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                        "                                        <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\n" +
                        "                                            <tbody>\n" +
                        "                                                <tr>\n" +
                        "                                                    <td class=\"esd-structure\" esd-general-paddings-checked=\"false\" style=\"background-color: #43285f;\" bgcolor=\"#43285f\" align=\"left\">\n" +
                        "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                        "                                                            <tbody>\n" +
                        "                                                                <tr>\n" +
                        "                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\n" +
                        "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                        "                                                                            <tbody>\n" +
                        "                                                                                <tr>\n" +
                        "                                                                                    <td class=\"esd-block-image\" align=\"center\" style=\"font-size:0\"><a target=\"_blank\" href><img class=\"adapt-img\" src=\"https://tlr.stripocdn.email/content/guids/CABINET_18b9b37a94ea92e75434475b4360dcd0/images/36441502442545607.jpg\" alt=\"Happy Birthday!\" title=\"Happy Birthday!\" width=\"600\"></a></td>\n" +
                        "                                                                                </tr>\n" +
                        "                                                                            </tbody>\n" +
                        "                                                                        </table>\n" +
                        "                                                                    </td>\n" +
                        "                                                                </tr>\n" +
                        "                                                            </tbody>\n" +
                        "                                                        </table>\n" +
                        "                                                    </td>\n" +
                        "                                                </tr>\n" +
                        "                                                <tr>\n" +
                        "                                                    <td class=\"esd-structure es-p30b\" esd-general-paddings-checked=\"false\" style=\"background-color: #43285f;\" bgcolor=\"#43285f\" align=\"left\">\n" +
                        "                                                        <!--[if mso]><table width=\"600\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"207\"><![endif]-->\n" +
                        "                                                        <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\n" +
                        "                                                            <tbody>\n" +
                        "                                                                <tr>\n" +
                        "                                                                    <td class=\"es-m-p0r es-m-p20b esd-container-frame\" width=\"187\" align=\"center\">\n" +
                        "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                        "                                                                            <tbody>\n" +
                        "                                                                                <tr class=\"es-hidden\">\n" +
                        "                                                                                    <td class=\"esd-block-image\" align=\"left\" style=\"font-size:0\"><a target=\"_blank\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_18b9b37a94ea92e75434475b4360dcd0/images/27021502445622301.jpg\" alt=\"Very lovely balloon\" title=\"Very lovely balloon\" width=\"116\"></a></td>\n" +
                        "                                                                                </tr>\n" +
                        "                                                                            </tbody>\n" +
                        "                                                                        </table>\n" +
                        "                                                                    </td>\n" +
                        "                                                                    <td class=\"es-hidden\" width=\"20\"></td>\n" +
                        "                                                                </tr>\n" +
                        "                                                            </tbody>\n" +
                        "                                                        </table>\n" +
                        "                                                        <!--[if mso]></td><td width=\"187\"><![endif]-->\n" +
                        "                                                        <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\n" +
                        "                                                            <tbody>\n" +
                        "                                                                <tr>\n" +
                        "                                                                    <td class=\"es-m-p20b esd-container-frame\" width=\"187\" align=\"center\">\n" +
                        "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                        "                                                                            <tbody>\n" +
                        "                                                                                <tr>\n" +
                        "                                                                                    <td class=\"esd-block-text es-p15t\" align=\"center\">\n" +
                        "                                                                                        <p style=\"line-height: 150%; color: #ffffff; font-size: 16px; font-family: arial, 'helvetica neue', helvetica, sans-serif;\">Dear " + u.getFullName() + ", it's your birthday and we think you deserve a little gift</p>\n" +
                        "                                                                                    </td>\n" +
                        "                                                                                </tr>\n" +
                        "                                                                            </tbody>\n" +
                        "                                                                        </table>\n" +
                        "                                                                    </td>\n" +
                        "                                                                </tr>\n" +
                        "                                                            </tbody>\n" +
                        "                                                        </table>\n" +
                        "                                                        <!--[if mso]></td><td width=\"20\"></td><td width=\"186\"><![endif]-->\n" +
                        "                                                        <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\n" +
                        "                                                            <tbody>\n" +
                        "                                                                <tr>\n" +
                        "                                                                    <td class=\"esd-container-frame\" width=\"186\" align=\"center\">\n" +
                        "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                        "                                                                            <tbody>\n" +
                        "                                                                                <tr class=\"es-hidden\">\n" +
                        "                                                                                    <td class=\"esd-block-image\" align=\"right\" style=\"font-size:0\"><a target=\"_blank\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_18b9b37a94ea92e75434475b4360dcd0/images/77061502445629778.jpg\" alt=\"Very lovely balloon\" title=\"Very lovely balloon\" width=\"111\"></a></td>\n" +
                        "                                                                                </tr>\n" +
                        "                                                                            </tbody>\n" +
                        "                                                                        </table>\n" +
                        "                                                                    </td>\n" +
                        "                                                                </tr>\n" +
                        "                                                            </tbody>\n" +
                        "                                                        </table>\n" +
                        "                                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
                        "                                                    </td>\n" +
                        "                                                </tr>\n" +
                        "                                            </tbody>\n" +
                        "                                        </table>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "                            </tbody>\n" +
                        "                        </table>\n" +
                        "                    </td>\n" +
                        "                </tr>\n" +
                        "            </tbody>\n" +
                        "        </table>\n" +
                        "    </div>\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>";
                emailService.sendMail(email, subject, content);
            }
        }
    }

    @PostMapping("/api/admin/send-birthday-email")
    public String sendBirthdayEmail(@RequestParam String email, @RequestParam String name) throws MessagingException {
        String subject = "Happy Birthday!!!";

        String content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                "    <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta content=\"telephone=no\" name=\"format-detection\">\n" +
                "    <title></title>\n" +
                "    <!--[if (mso 16)]>\n" +
                "    <style type=\"text/css\">\n" +
                "    a {text-decoration: none;}\n" +
                "    </style>\n" +
                "    <![endif]-->\n" +
                "    <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\n" +
                "    <!--[if gte mso 9]>\n" +
                "<xml>\n" +
                "    <o:OfficeDocumentSettings>\n" +
                "    <o:AllowPNG></o:AllowPNG>\n" +
                "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "    </o:OfficeDocumentSettings>\n" +
                "</xml>\n" +
                "<![endif]-->\n" +
                "    <style>\n" +
                "        /* CONFIG STYLES Please do not delete and edit CSS styles below */\n" +
                "        /* IMPORTANT THIS STYLES MUST BE ON FINAL EMAIL */\n" +
                "        #outlook a {\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        .ExternalClass {\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        .ExternalClass,\n" +
                "        .ExternalClass p,\n" +
                "        .ExternalClass span,\n" +
                "        .ExternalClass font,\n" +
                "        .ExternalClass td,\n" +
                "        .ExternalClass div {\n" +
                "            line-height: 100%;\n" +
                "        }\n" +
                "\n" +
                "        .es-button {\n" +
                "            mso-style-priority: 100 !important;\n" +
                "            text-decoration: none !important;\n" +
                "        }\n" +
                "\n" +
                "        a[x-apple-data-detectors] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: none !important;\n" +
                "            font-size: inherit !important;\n" +
                "            font-family: inherit !important;\n" +
                "            font-weight: inherit !important;\n" +
                "            line-height: inherit !important;\n" +
                "        }\n" +
                "\n" +
                "        .es-desk-hidden {\n" +
                "            display: none;\n" +
                "            float: left;\n" +
                "            overflow: hidden;\n" +
                "            width: 0;\n" +
                "            max-height: 0;\n" +
                "            line-height: 0;\n" +
                "            mso-hide: all;\n" +
                "        }\n" +
                "\n" +
                "        /*\n" +
                "END OF IMPORTANT\n" +
                "*/\n" +
                "        s {\n" +
                "            text-decoration: line-through;\n" +
                "        }\n" +
                "\n" +
                "        html,\n" +
                "        body {\n" +
                "            width: 100%;\n" +
                "            -webkit-text-size-adjust: 100%;\n" +
                "            -ms-text-size-adjust: 100%;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            font-family: 'arial', 'helvetica neue', 'helvetica', 'sans-serif';\n" +
                "        }\n" +
                "\n" +
                "        table {\n" +
                "            mso-table-lspace: 0pt;\n" +
                "            mso-table-rspace: 0pt;\n" +
                "            border-collapse: collapse;\n" +
                "            border-spacing: 0px;\n" +
                "        }\n" +
                "\n" +
                "        table td,\n" +
                "        html,\n" +
                "        body,\n" +
                "        .es-wrapper {\n" +
                "            padding: 0;\n" +
                "            Margin: 0;\n" +
                "        }\n" +
                "\n" +
                "        .es-content,\n" +
                "        .es-header,\n" +
                "        .es-footer {\n" +
                "            table-layout: fixed !important;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        img {\n" +
                "            display: block;\n" +
                "            border: 0;\n" +
                "            outline: none;\n" +
                "            text-decoration: none;\n" +
                "            -ms-interpolation-mode: bicubic;\n" +
                "        }\n" +
                "\n" +
                "        table tr {\n" +
                "            border-collapse: collapse;\n" +
                "        }\n" +
                "\n" +
                "        p,\n" +
                "        hr {\n" +
                "            Margin: 0;\n" +
                "        }\n" +
                "\n" +
                "        h1,\n" +
                "        h2,\n" +
                "        h3,\n" +
                "        h4,\n" +
                "        h5 {\n" +
                "            Margin: 0;\n" +
                "            line-height: 120%;\n" +
                "            mso-line-height-rule: exactly;\n" +
                "            font-family: 'arial', 'helvetica neue', 'helvetica', 'sans-serif';\n" +
                "        }\n" +
                "\n" +
                "        p,\n" +
                "        ul li,\n" +
                "        ol li,\n" +
                "        a {\n" +
                "            -webkit-text-size-adjust: none;\n" +
                "            -ms-text-size-adjust: none;\n" +
                "            mso-line-height-rule: exactly;\n" +
                "        }\n" +
                "\n" +
                "        .es-left {\n" +
                "            float: left;\n" +
                "        }\n" +
                "\n" +
                "        .es-right {\n" +
                "            float: right;\n" +
                "        }\n" +
                "\n" +
                "        .es-p5 {\n" +
                "            padding: 5px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p5t {\n" +
                "            padding-top: 5px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p5b {\n" +
                "            padding-bottom: 5px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p5l {\n" +
                "            padding-left: 5px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p5r {\n" +
                "            padding-right: 5px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p10 {\n" +
                "            padding: 10px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p10t {\n" +
                "            padding-top: 10px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p10b {\n" +
                "            padding-bottom: 10px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p10l {\n" +
                "            padding-left: 10px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p10r {\n" +
                "            padding-right: 10px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p15 {\n" +
                "            padding: 15px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p15t {\n" +
                "            padding-top: 15px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p15b {\n" +
                "            padding-bottom: 15px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p15l {\n" +
                "            padding-left: 15px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p15r {\n" +
                "            padding-right: 15px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p20 {\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p20t {\n" +
                "            padding-top: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p20b {\n" +
                "            padding-bottom: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p20l {\n" +
                "            padding-left: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p20r {\n" +
                "            padding-right: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p25 {\n" +
                "            padding: 25px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p25t {\n" +
                "            padding-top: 25px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p25b {\n" +
                "            padding-bottom: 25px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p25l {\n" +
                "            padding-left: 25px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p25r {\n" +
                "            padding-right: 25px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p30 {\n" +
                "            padding: 30px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p30t {\n" +
                "            padding-top: 30px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p30b {\n" +
                "            padding-bottom: 30px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p30l {\n" +
                "            padding-left: 30px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p30r {\n" +
                "            padding-right: 30px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p35 {\n" +
                "            padding: 35px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p35t {\n" +
                "            padding-top: 35px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p35b {\n" +
                "            padding-bottom: 35px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p35l {\n" +
                "            padding-left: 35px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p35r {\n" +
                "            padding-right: 35px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p40 {\n" +
                "            padding: 40px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p40t {\n" +
                "            padding-top: 40px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p40b {\n" +
                "            padding-bottom: 40px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p40l {\n" +
                "            padding-left: 40px;\n" +
                "        }\n" +
                "\n" +
                "        .es-p40r {\n" +
                "            padding-right: 40px;\n" +
                "        }\n" +
                "\n" +
                "        .es-menu td {\n" +
                "            border: 0;\n" +
                "        }\n" +
                "\n" +
                "        .es-menu td a {\n" +
                "            text-decoration: none;\n" +
                "            display: block;\n" +
                "            font-family: 'arial', 'helvetica neue', 'helvetica', 'sans-serif';\n" +
                "        }\n" +
                "\n" +
                "        .es-menu td a img {\n" +
                "            display: inline-block !important;\n" +
                "        }\n" +
                "\n" +
                "        /* END CONFIG STYLES */\n" +
                "        a {\n" +
                "            text-decoration: underline;\n" +
                "        }\n" +
                "\n" +
                "        p,\n" +
                "        ul li,\n" +
                "        ol li {\n" +
                "            font-family: 'arial', 'helvetica neue', 'helvetica', 'sans-serif';\n" +
                "            line-height: 150%;\n" +
                "        }\n" +
                "\n" +
                "        ul li,\n" +
                "        ol li {\n" +
                "            Margin-bottom: 15px;\n" +
                "            margin-left: 0;\n" +
                "        }\n" +
                "\n" +
                "        .es-wrapper {\n" +
                "            width: 100%;\n" +
                "            height: 100%;\n" +
                "            background-repeat: repeat;\n" +
                "            background-position: center top;\n" +
                "        }\n" +
                "\n" +
                "        .es-wrapper-color,\n" +
                "        .es-wrapper {\n" +
                "            background-color: #efefef;\n" +
                "        }\n" +
                "\n" +
                "        .es-header {\n" +
                "            background-color: transparent;\n" +
                "            background-repeat: repeat;\n" +
                "            background-position: center top;\n" +
                "        }\n" +
                "\n" +
                "        .es-header-body {\n" +
                "            background-color: #ffffff;\n" +
                "        }\n" +
                "\n" +
                "        .es-header-body p,\n" +
                "        .es-header-body ul li,\n" +
                "        .es-header-body ol li {\n" +
                "            color: #333333;\n" +
                "            font-size: 14px;\n" +
                "        }\n" +
                "\n" +
                "        .es-header-body a {\n" +
                "            color: #000000;\n" +
                "            font-size: 14px;\n" +
                "        }\n" +
                "\n" +
                "        .es-content-body {\n" +
                "            background-color: #ffffff;\n" +
                "        }\n" +
                "\n" +
                "        .es-content-body p,\n" +
                "        .es-content-body ul li,\n" +
                "        .es-content-body ol li {\n" +
                "            color: #333333;\n" +
                "            font-size: 14px;\n" +
                "        }\n" +
                "\n" +
                "        .es-content-body a {\n" +
                "            color: #000000;\n" +
                "            font-size: 14px;\n" +
                "        }\n" +
                "\n" +
                "        .es-footer {\n" +
                "            background-color: transparent;\n" +
                "            background-repeat: repeat;\n" +
                "            background-position: center top;\n" +
                "        }\n" +
                "\n" +
                "        .es-footer-body {\n" +
                "            background-color: transparent;\n" +
                "        }\n" +
                "\n" +
                "        .es-footer-body p,\n" +
                "        .es-footer-body ul li,\n" +
                "        .es-footer-body ol li {\n" +
                "            color: #333333;\n" +
                "            font-size: 12px;\n" +
                "        }\n" +
                "\n" +
                "        .es-footer-body a {\n" +
                "            color: #000000;\n" +
                "            font-size: 12px;\n" +
                "        }\n" +
                "\n" +
                "        .es-infoblock,\n" +
                "        .es-infoblock p,\n" +
                "        .es-infoblock ul li,\n" +
                "        .es-infoblock ol li {\n" +
                "            line-height: 120%;\n" +
                "            font-size: 12px;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "\n" +
                "        .es-infoblock a {\n" +
                "            font-size: 12px;\n" +
                "            color: #000000;\n" +
                "        }\n" +
                "\n" +
                "        h1 {\n" +
                "            font-size: 34px;\n" +
                "            font-style: normal;\n" +
                "            font-weight: bold;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "\n" +
                "        h2 {\n" +
                "            font-size: 26px;\n" +
                "            font-style: normal;\n" +
                "            font-weight: bold;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "\n" +
                "        h3 {\n" +
                "            font-size: 20px;\n" +
                "            font-style: normal;\n" +
                "            font-weight: normal;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "\n" +
                "        .es-header-body h1 a,\n" +
                "        .es-content-body h1 a,\n" +
                "        .es-footer-body h1 a {\n" +
                "            font-size: 34px;\n" +
                "        }\n" +
                "\n" +
                "        .es-header-body h2 a,\n" +
                "        .es-content-body h2 a,\n" +
                "        .es-footer-body h2 a {\n" +
                "            font-size: 26px;\n" +
                "        }\n" +
                "\n" +
                "        .es-header-body h3 a,\n" +
                "        .es-content-body h3 a,\n" +
                "        .es-footer-body h3 a {\n" +
                "            font-size: 20px;\n" +
                "        }\n" +
                "\n" +
                "        a.es-button,\n" +
                "        button.es-button {\n" +
                "            display: inline-block;\n" +
                "            background: #ffffff;\n" +
                "            border-radius: 0px;\n" +
                "            font-size: 18px;\n" +
                "            font-family: 'arial', 'helvetica neue', 'helvetica', 'sans-serif';\n" +
                "            font-weight: bold;\n" +
                "            font-style: normal;\n" +
                "            line-height: 120%;\n" +
                "            color: #9a7baa;\n" +
                "            text-decoration: none;\n" +
                "            width: auto;\n" +
                "            text-align: center;\n" +
                "            padding: 10px 20px 10px 20px;\n" +
                "            mso-padding-alt: 0;\n" +
                "            mso-border-alt: 10px solid #ffffff;\n" +
                "        }\n" +
                "\n" +
                "        .es-button-border {\n" +
                "            border-style: solid solid solid solid;\n" +
                "            border-color: #ffffff #ffffff #ffffff #ffffff;\n" +
                "            background: #2cb543;\n" +
                "            border-width: 0px 0px 0px 0px;\n" +
                "            display: inline-block;\n" +
                "            border-radius: 0px;\n" +
                "            width: auto;\n" +
                "        }\n" +
                "\n" +
                "        /* RESPONSIVE STYLES Please do not delete and edit CSS styles below. If you don't need responsive layout, please delete this section. */\n" +
                "        @media only screen and (max-width: 600px) {\n" +
                "\n" +
                "            p,\n" +
                "            ul li,\n" +
                "            ol li,\n" +
                "            a {\n" +
                "                line-height: 150% !important;\n" +
                "            }\n" +
                "\n" +
                "            h1,\n" +
                "            h2,\n" +
                "            h3,\n" +
                "            h1 a,\n" +
                "            h2 a,\n" +
                "            h3 a {\n" +
                "                line-height: 120% !important;\n" +
                "            }\n" +
                "\n" +
                "            h1 {\n" +
                "                font-size: 30px !important;\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "\n" +
                "            h2 {\n" +
                "                font-size: 26px !important;\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "\n" +
                "            h3 {\n" +
                "                font-size: 20px !important;\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "\n" +
                "            .es-header-body h1 a,\n" +
                "            .es-content-body h1 a,\n" +
                "            .es-footer-body h1 a {\n" +
                "                font-size: 30px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-header-body h2 a,\n" +
                "            .es-content-body h2 a,\n" +
                "            .es-footer-body h2 a {\n" +
                "                font-size: 26px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-header-body h3 a,\n" +
                "            .es-content-body h3 a,\n" +
                "            .es-footer-body h3 a {\n" +
                "                font-size: 20px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-header-body p,\n" +
                "            .es-header-body ul li,\n" +
                "            .es-header-body ol li,\n" +
                "            .es-header-body a {\n" +
                "                font-size: 16px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-content-body p,\n" +
                "            .es-content-body ul li,\n" +
                "            .es-content-body ol li,\n" +
                "            .es-content-body a {\n" +
                "                font-size: 16px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-footer-body p,\n" +
                "            .es-footer-body ul li,\n" +
                "            .es-footer-body ol li,\n" +
                "            .es-footer-body a {\n" +
                "                font-size: 16px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-infoblock p,\n" +
                "            .es-infoblock ul li,\n" +
                "            .es-infoblock ol li,\n" +
                "            .es-infoblock a {\n" +
                "                font-size: 12px !important;\n" +
                "            }\n" +
                "\n" +
                "            *[class=\"gmail-fix\"] {\n" +
                "                display: none !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-m-txt-c,\n" +
                "            .es-m-txt-c h1,\n" +
                "            .es-m-txt-c h2,\n" +
                "            .es-m-txt-c h3 {\n" +
                "                text-align: center !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-m-txt-r,\n" +
                "            .es-m-txt-r h1,\n" +
                "            .es-m-txt-r h2,\n" +
                "            .es-m-txt-r h3 {\n" +
                "                text-align: right !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-m-txt-l,\n" +
                "            .es-m-txt-l h1,\n" +
                "            .es-m-txt-l h2,\n" +
                "            .es-m-txt-l h3 {\n" +
                "                text-align: left !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-m-txt-r img,\n" +
                "            .es-m-txt-c img,\n" +
                "            .es-m-txt-l img {\n" +
                "                display: inline !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-button-border {\n" +
                "                display: block !important;\n" +
                "            }\n" +
                "\n" +
                "            a.es-button,\n" +
                "            button.es-button {\n" +
                "                font-size: 20px !important;\n" +
                "                display: block !important;\n" +
                "                padding: 10px 0px 10px 0px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-btn-fw {\n" +
                "                border-width: 10px 0px !important;\n" +
                "                text-align: center !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-adaptive table,\n" +
                "            .es-btn-fw,\n" +
                "            .es-btn-fw-brdr,\n" +
                "            .es-left,\n" +
                "            .es-right {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-content table,\n" +
                "            .es-header table,\n" +
                "            .es-footer table,\n" +
                "            .es-content,\n" +
                "            .es-footer,\n" +
                "            .es-header {\n" +
                "                width: 100% !important;\n" +
                "                max-width: 600px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-adapt-td {\n" +
                "                display: block !important;\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .adapt-img {\n" +
                "                width: 100% !important;\n" +
                "                height: auto !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p0 {\n" +
                "                padding: 0px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p0r {\n" +
                "                padding-right: 0px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p0l {\n" +
                "                padding-left: 0px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p0t {\n" +
                "                padding-top: 0px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p0b {\n" +
                "                padding-bottom: 0 !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-m-p20b {\n" +
                "                padding-bottom: 20px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-mobile-hidden,\n" +
                "            .es-hidden {\n" +
                "                display: none !important;\n" +
                "            }\n" +
                "\n" +
                "            tr.es-desk-hidden,\n" +
                "            td.es-desk-hidden,\n" +
                "            table.es-desk-hidden {\n" +
                "                width: auto !important;\n" +
                "                overflow: visible !important;\n" +
                "                float: none !important;\n" +
                "                max-height: inherit !important;\n" +
                "                line-height: inherit !important;\n" +
                "            }\n" +
                "\n" +
                "            tr.es-desk-hidden {\n" +
                "                display: table-row !important;\n" +
                "            }\n" +
                "\n" +
                "            table.es-desk-hidden {\n" +
                "                display: table !important;\n" +
                "            }\n" +
                "\n" +
                "            td.es-desk-menu-hidden {\n" +
                "                display: table-cell !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-menu td {\n" +
                "                width: 1% !important;\n" +
                "            }\n" +
                "\n" +
                "            table.es-table-not-adapt,\n" +
                "            .esd-block-html table {\n" +
                "                width: auto !important;\n" +
                "            }\n" +
                "\n" +
                "            table.es-social {\n" +
                "                display: inline-block !important;\n" +
                "            }\n" +
                "\n" +
                "            table.es-social td {\n" +
                "                display: inline-block !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-menu td a {\n" +
                "                font-size: 14px !important;\n" +
                "            }\n" +
                "\n" +
                "            .es-desk-hidden {\n" +
                "                display: table-row !important;\n" +
                "                width: auto !important;\n" +
                "                overflow: visible !important;\n" +
                "                max-height: inherit !important;\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        /* END RESPONSIVE STYLES */\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body data-new-gr-c-s-loaded=\"14.1030.0\">\n" +
                "    <div class=\"es-wrapper-color\">\n" +
                "        <!--[if gte mso 9]>\n" +
                "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "\t\t\t\t<v:fill type=\"tile\" color=\"#efefef\"></v:fill>\n" +
                "\t\t\t</v:background>\n" +
                "\t\t<![endif]-->\n" +
                "        <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td class=\"esd-email-paddings\" valign=\"top\">\n" +
                "                        <table class=\"es-content esd-footer-popover\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure\" esd-general-paddings-checked=\"false\" style=\"background-color: #43285f;\" bgcolor=\"#43285f\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-image\" align=\"center\" style=\"font-size:0\"><a target=\"_blank\" href><img class=\"adapt-img\" src=\"https://tlr.stripocdn.email/content/guids/CABINET_18b9b37a94ea92e75434475b4360dcd0/images/36441502442545607.jpg\" alt=\"Happy Birthday!\" title=\"Happy Birthday!\" width=\"600\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p30b\" esd-general-paddings-checked=\"false\" style=\"background-color: #43285f;\" bgcolor=\"#43285f\" align=\"left\">\n" +
                "                                                        <!--[if mso]><table width=\"600\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"207\"><![endif]-->\n" +
                "                                                        <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"es-m-p0r es-m-p20b esd-container-frame\" width=\"187\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr class=\"es-hidden\">\n" +
                "                                                                                    <td class=\"esd-block-image\" align=\"left\" style=\"font-size:0\"><a target=\"_blank\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_18b9b37a94ea92e75434475b4360dcd0/images/27021502445622301.jpg\" alt=\"Very lovely balloon\" title=\"Very lovely balloon\" width=\"116\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                    <td class=\"es-hidden\" width=\"20\"></td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                        <!--[if mso]></td><td width=\"187\"><![endif]-->\n" +
                "                                                        <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"es-m-p20b esd-container-frame\" width=\"187\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text es-p15t\" align=\"center\">\n" +
                "                                                                                        <p style=\"line-height: 150%; color: #ffffff; font-size: 16px; font-family: arial, 'helvetica neue', helvetica, sans-serif;\">Dear " + name + ", it's your birthday and we think you deserve a little gift</p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                        <!--[if mso]></td><td width=\"20\"></td><td width=\"186\"><![endif]-->\n" +
                "                                                        <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"186\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr class=\"es-hidden\">\n" +
                "                                                                                    <td class=\"esd-block-image\" align=\"right\" style=\"font-size:0\"><a target=\"_blank\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_18b9b37a94ea92e75434475b4360dcd0/images/77061502445629778.jpg\" alt=\"Very lovely balloon\" title=\"Very lovely balloon\" width=\"111\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</body>\n" +
                "\n" +
                "</html>";

        return emailService.sendMail(email, subject, content);
    }

}
