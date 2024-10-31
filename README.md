# پیام‌رسان قزمیت
‍
## گام ۱: افزودن یک روش پیام رسانی دیگر

<table dir='rtl'>
<tbody>
<tr>
<td width="64">
<p><strong>ردیف</strong></p>
</td>
<td width="198">
<p><strong>محل اعمال تغییرات (کلاس/واسط)</strong></p>
</td>
<td width="141">
<p><strong>عنوان تغییر</strong></p>
</td>
<td width="292">
<p><strong>شرحی کوتاه از تغییر</strong></p>
</td>
</tr>

<tr>
<td width="64">
</td>
<td width="198">
<p>MessageService</p>
</td>
<td width="141">
<p>افزودن تابع ارسال پیام تلگرامی</p>
</td>
<td width="292">
<p>افزودن یک تابع void با عنوان sendTelegramMessage</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>&nbsp;</strong></p>
</td>
<td width="198">
<p>models</p>
</td>
<td width="141">
<p>افزودن کلاس TelegramMessage</p>
</td>
<td width="292">
<p>افزودن مدل پیام تلگرامی که از Message ارث‌بری می‌کند.</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>&nbsp;</strong></p>
</td>
<td width="198">
<p>services</p>
</td>
<td width="141">
<p>افزودن کلاس TelegramMessageService</p>
</td>
<td width="292">
<p>افزودن و پیاده‌سازی توابع این‌سرویس که از interface MessageService آمده است. متود ارسال پیام تلگرام که به دلیل ابسترکت بودن MessageService باید به SmsMessageService و EmailMessageService نیز اضافه شده است..</p>
</td>
</tr>


<tr>
<td width="64">
<p><strong>&nbsp;</strong></p>
</td>
<td width="198">
<p>Main.java</p>
</td>
<td width="141">
<p>افزودن آپشن ارسال پیام تلگرامی به printها</p>
</td>
<td width="292">
<p>افزودن عدد ۳ برای ارسال پیام تلگرامی به کاربر دیگر</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>&nbsp;</strong></p>
</td>
<td width="198">
<p>Main.java</p>
</td>
<td width="141">
<p>افزودن شرط‌های متناسب با آپشن ارسال پیام تلگرامی (مانند دو آپشن قبلی) در صورتی که پیام از جنس TelegramMessage باشد، آن را با سرویس TelegramMessageService ارسال می‌کنیم.</p>
</td>
<td width="292">
<p>&nbsp;</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>&nbsp;</strong></p>
</td>
<td width="198">
<p>TelegramMessageService</p>
</td>
<td width="141">
<p>افزودن تابع متناسب با validate کردن آیدی تلگرام</p>
</td>
<td width="292">
<p>این تابع چک می‌کند که آیا آیدی تلگرامی مبدا و مقصد مطابق الگوی مربوطه است یا خیر.</p>
</td>
</tr>
</tbody>
</table>





مجموع تعداد تغییرات: 6

### گام ۲: تحلیل و وارسی برنامه از منظر تحقق و یا عدم تحقق اصول SOLID
در خصوص این برنامه‌ای که نوشته شده بود و شما یک قابلیت به آن اضافه کردید، بر اساس اصول SOLID موارد نقض و یا محقق شدن هر کدام از آن اصول را بیان کنید. در بیان موارد تحقق و نقض، علت تحقق و یا نقض را نیز به صورت کامل توضیح دهید:

<table dir='rtl'>
<tbody>
<tr>
<td rowspan="2" width="240">
<p>اصل 1</p>
<p>Single Responsibility</p>
</td>
<td width="95">
<p><strong>موارد تحقق</strong></p>
</td>
<td width="454">
<p>مطابق کد مشخص است که هرکدام از کلاس‌های  EmailMessageService, SmsMessageService و TelegramMessageService برای ارسال نوع خاصی از پیام پیاده‌سازی شده‌اند در نتیجه این اصل رعایت شده است.</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 2</p>
<p>Open-Close Principle (OCP)</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>با توجه به اینکه برای اضافه کردن سرویس ارسال پیام تلگرام توانستیم از اینترفیس MessageService استفاده کنیم این مورد تا حدودی رعایت شده بود. می‌گوییم تا جدودی چون که مورد نقض هم دارد. در ادامه می‌بینیم.</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>برای اضافه کردن قابلیت و feature جدید به کد، مجبور شدیم که کلاس‌های SmsMessageService و EmailMessageService را نیز دست‌خوش تغییر کنیم. حتی با اینکه تابع مورد نظر empty body بود.</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 3</p>
<p>Liskov Substitution Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>این اصل تحقق یافته و نقض نشده است. با توجه به استفاده‌ی کلاس Message و ارث‌بری از آن توسط سایر پیام‌رسان‌ها می‌توان این را مشاهده کرد.</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 4</p>
<p>Interface Segregation Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>این مورد نقض شده است. همانطور که بالاتر نیز گفیم، باید توابع مربوط به ارسال پیام email و sms را در تلگرام نیز پیاده‌سازی می‌کردیم و بالعکس.</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 5</p>
<p>Dependency Inversion Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>با توجه به اینکه در ارسال پیام باید به اینکه پیام از چه جنسی هست توجه میشد این اصل نقض شده است. در فایل Main.java این مورد هنگام ارسال پیام از نوع‌های متفاوت مشخص است.</p>
</td>
</tr>
</tbody>
</table>

در خصوص هرکدام از موارد نقض هرکدام از اصول، یک راهکار را به منظور رفع آن مشکل ارایه داده و در جدول زیر ثبت نمایید:

<table dir='rtl'>
<tbody>
<tr>
<td width="168">
<p><strong>اصل مربوطه (از اصول </strong><strong>SOLID</strong><strong>)</strong></p>
</td>
<td width="246">
<p><strong>علت نقض</strong></p>
</td>
<td width="284">
<p><strong>راه حل پیشنهادی</strong></p>
</td>
</tr>
<tr>
<td width="168">
<p>&nbsp;</p>
</td>
<td width="246">
<p>&nbsp;</p>
</td>
<td width="284">
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td width="168">
<p>&nbsp;</p>
</td>
<td width="246">
<p>&nbsp;</p>
</td>
<td width="284">
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td width="168">
<p>&nbsp;</p>
</td>
<td width="246">
<p>&nbsp;</p>
</td>
<td width="284">
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td width="168">
<p>&nbsp;</p>
</td>
<td width="246">
<p>&nbsp;</p>
</td>
<td width="284">
<p>&nbsp;</p>
</td>
</tr>
</tbody>
</table>
