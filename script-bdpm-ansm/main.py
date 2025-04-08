from ansm_bdpm_tools import fetch,decoder,filter_bdpm,format_ansm

def main() :
    fetch.fetch_sources("sources/raws")
    decoder.format_dir("sources/raws","sources/formated")
    

if __name__  == "__main__":
    main()