# پیام‌رسان قزمیت

## توضیح پروژه
این پروژه یک سیستم پیام‌رسان ساده است که ارسال پیام‌ها را از طریق ایمیل، پیامک و تلگرام مدیریت می‌کند. این سیستم با رعایت اصول SOLID طراحی شده و به راحتی قابل گسترش است.

## اعضای گروه

نام و نام خانوادگی نفر اول (سرگروه): `Ahmadreza Khanari`
شماره دانشجویی نفر اول: `99170412`

‍نام و نام خانوادگی نفر دوم: `Amir Hossein Arabzadeh`
شماره دانشجویی نفر دوم: `98105908`

نام و نام خانوادگی نفر سوم: `AmirMahdi Kousheshi`
شماره دانشجویی نفر سوم: `98171053`

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
  1
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
2
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
3
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
4
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
5
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
6
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
7
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

مجموع تعداد تغییرات: 7

## گام ۲: تحلیل و وارسی برنامه از منظر تحقق و یا عدم تحقق اصول SOLID
بر اساس اصول SOLID، ارزیابی انجام شده بر روی برنامه به شرح زیر است:

<table dir='rtl'>
  <thead>
    <tr>
      <th>اصل</th>
      <th>موارد تحقق</th>
      <th>موارد نقض</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="2"><p>اصل 1</p><p>Single Responsibility</p></td>
      <td><strong>موارد تحقق</strong></td>
      <td>هرکدام از کلاس‌های EmailMessageService, SmsMessageService و TelegramMessageService تنها مسئولیت ارسال یک نوع خاص پیام را دارند و این اصل رعایت شده است.</td>
    </tr>
    <tr>
      <td><strong>موارد نقض</strong></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td rowspan="2"><p>اصل 2</p><p>Open-Close Principle (OCP)</p></td>
      <td><strong>موارد تحقق</strong></td>
      <td>در ایجاد سرویس پیام تلگرام از اینترفیس MessageService استفاده شد و این اصل تا حدی رعایت گردید.</td>
    </tr>
    <tr>
      <td><strong>موارد نقض</strong></td>
      <td>برای افزودن قابلیت جدید، مجبور به تغییر SmsMessageService و EmailMessageService شدیم. بنابراین، این اصل نقض شده است.</td>
    </tr>
    <tr>
      <td rowspan="2"><p>اصل 3</p><p>Liskov Substitution Principle</p></td>
      <td><strong>موارد تحقق</strong></td>
      <td>کلاس‌های مختلف پیام‌رسانی به درستی از Message ارث‌بری می‌کنند و اصل LSP رعایت شده است.</td>
    </tr>
    <tr>
      <td><strong>موارد نقض</strong></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td rowspan="2"><p>اصل 4</p><p>Interface Segregation Principle</p></td>
      <td><strong>موارد تحقق</strong></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td><strong>موارد نقض</strong></td>
      <td>اینترفیس مشترک باعث ایجاد متدهای اضافی شد که نیازی به آن‌ها در برخی از سرویس‌ها نبود.</td>
    </tr>
    <tr>
      <td rowspan="2"><p>اصل 5</p><p>Dependency Inversion Principle</p></td>
      <td><strong>موارد تحقق</strong></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td><strong>موارد نقض</strong></td>
      <td>وابستگی Main به کلاس‌های مشخص نقض DIP بود و باید به جای وابستگی به پیاده‌سازی خاص، به اینترفیس‌های انتزاعی وابسته باشد.</td>
    </tr>
  </tbody>
</table>

## گام ۳: راه‌حل‌های پیشنهادی برای رفع نقض SOLID

برای رفع نقض اصول SOLID، راه‌حل‌های زیر پیشنهاد می‌شود:

<table dir='rtl'>
  <thead>
    <tr>
      <th width="168"><strong>اصل مربوطه (از اصول SOLID)</strong></th>
      <th width="246"><strong>علت نقض</strong></th>
      <th width="284"><strong>راه حل پیشنهادی</strong></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td width="168">Open-Closed Principle (OCP)</td>
      <td width="246">افزودن قابلیت جدید نیازمند تغییر در کلاس‌های موجود بود.</td>
      <td width="284">استفاده از الگوی Factory یا Strategy برای افزودن انواع جدید پیام بدون نیاز به تغییر در کلاس‌های موجود.</td>
    </tr>
    <tr>
      <td width="168">Interface Segregation Principle (ISP)</td>
      <td width="246">اینترفیس‌های مشترک باعث متدهای غیرضروری شدند.</td>
      <td width="284">ایجاد اینترفیس‌های جداگانه برای هر نوع پیام (مانند <code>EmailService</code> و <code>SmsService</code>) به جای استفاده از یک اینترفیس عمومی.</td>
    </tr>
    <tr>
      <td width="168">Dependency Inversion Principle (DIP)</td>
      <td width="246">وابستگی <code>Main</code> به کلاس‌های خاص نقض DIP بود.</td>
      <td width="284">استفاده از Dependency Injection برای وابسته کردن <code>Main</code> به اینترفیس‌های انتزاعی به جای پیاده‌سازی‌های مشخص.</td>
    </tr>
  </tbody>
</table>

## سوالات پایانی
### 1. اگر اصول شی گرایی از ابتدا برقرار بود و شما سرویس جدید را به پروژه اضافه می کردید، چند مورد از تغییرات ثبت شده در جدول مرحله دوم حذف می شد؟ و در نهایت با چند تغییر در سطح کد، این سرویس اضافه می شد؟ (عدد آن را حتما اعلام کنید).

دو مورد از تغییرات ثبت شده در جدول مرحله دوم که اضافه کردن تابع ارسال پیام به EmailMessageService و SMSMessageService حذف میشد. همچنین در نهایت با 8 تغییر که 3 تغییر، ایجاد کلاس پدر مخصوص هر سرویس میباشد.

### 2. با توجه به آنچه که انجام دادید، در دو خط توضیح دهید که رعایت اصول شی گرایی، چه مزایایی را برای پروژه شما فراهم میکند؟
رعایت اصول شی‌گرایی در پروژه، امکان توسعه‌پذیری، انعطاف‌پذیری و تغییرپذیری بالاتری را فراهم می‌کند. این اصول به جداسازی مسئولیت‌ها و کاهش وابستگی‌ها کمک می‌کنند، که در نتیجه افزودن یا تغییر قابلیت‌ها بدون تأثیر منفی بر بخش‌های دیگر پروژه آسان‌تر می‌شود.

