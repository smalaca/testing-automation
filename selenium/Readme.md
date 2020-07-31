## Downloading WebDrivers
Download:
- [ChromeDriver](https://chromedriver.chromium.org/downloads)
- [GeckoDriver](https://github.com/mozilla/geckodriver/releases)
- [EdgeDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)

Remember to download driver that will work with your browser's version.

## How to verify if you have got correct WevDrivers?
1. Open `config.properties` file.
2. File paths to webdrivers should point to their locations on your host.
3. Run tests:
    - `EdgeTest` - to verify EdgeDriver configuration
    - `FirefoxTest` - to verify GeckoDriver configuration
    - `GoogleChromeTest` - to verify ChromeDriver configuration